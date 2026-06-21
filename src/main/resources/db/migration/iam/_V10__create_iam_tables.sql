CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE SCHEMA IF NOT EXISTS iam;

-- =========================
-- USER ACCOUNT
-- =========================
CREATE TABLE iam.user_account (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employee_id UUID NOT NULL UNIQUE,
    username VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    token_version INTEGER NOT NULL DEFAULT 0,
    account_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    account_non_locked BOOLEAN NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    failed_login_attempts INTEGER NOT NULL DEFAULT 0,
    last_login_at TIMESTAMP,
    password_changed_at TIMESTAMP,
    locked_until TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_account_employee
    FOREIGN KEY (employee_id)
      REFERENCES core.employee(id)
);
CREATE INDEX idx_user_account_employee_id
    ON iam.user_account(employee_id);


-- =========================
-- ROLE
-- =========================
CREATE TABLE iam.role (
      id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
      code VARCHAR(100) NOT NULL UNIQUE,
      name VARCHAR(255) NOT NULL,
      description TEXT,
      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- PERMISSION
-- =========================
CREATE TABLE iam.permission (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- USER ROLE
-- =========================
CREATE TABLE iam.user_role (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   user_account_id UUID NOT NULL,
   role_id UUID NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   CONSTRAINT uk_user_role
       UNIQUE(user_account_id, role_id),

   CONSTRAINT fk_user_role_user
       FOREIGN KEY (user_account_id)
           REFERENCES iam.user_account(id),

   CONSTRAINT fk_user_role_role
       FOREIGN KEY (role_id)
           REFERENCES iam.role(id)
);
CREATE INDEX idx_user_role_user_account_id
    ON iam.user_role(user_account_id);

CREATE INDEX idx_user_role_role_id
    ON iam.user_role(role_id);

-- =========================
-- ROLE PERMISSION
-- =========================
CREATE TABLE iam.role_permission (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     role_id UUID NOT NULL,
     permission_id UUID NOT NULL,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

     CONSTRAINT uk_role_permission
         UNIQUE(role_id, permission_id),

     CONSTRAINT fk_role_permission_role
         FOREIGN KEY (role_id)
             REFERENCES iam.role(id),

     CONSTRAINT fk_role_permission_permission
         FOREIGN KEY (permission_id)
             REFERENCES iam.permission(id)
);
CREATE INDEX idx_role_permission_role_id
    ON iam.role_permission(role_id);

CREATE INDEX idx_role_permission_permission_id
    ON iam.role_permission(permission_id);

-- =========================================
-- SECURITY AUDIT LOG
-- =========================================
CREATE TABLE iam.security_audit_log (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(100) NOT NULL,
    event_type VARCHAR(50) NOT NULL,
    -- Example: LOGIN_SUCCESS, LOGIN_FAILED, LOGOUT, PASSWORD_CHANGE, ROLE_ASSIGN
    event_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    success BOOLEAN NOT NULL,
    ip_address VARCHAR(100),
    user_agent TEXT,
    details TEXT,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX idx_audit_username
    ON iam.security_audit_log(username);

CREATE INDEX idx_audit_event_type
    ON iam.security_audit_log(event_type);

CREATE INDEX idx_audit_event_time
    ON iam.security_audit_log(event_time);

-- =========================================
-- REFRESH TOKEN TABLE
-- =========================================
CREATE TABLE iam.refresh_token (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

   user_id UUID NOT NULL,

   token TEXT NOT NULL UNIQUE,

   session_id VARCHAR(100) NOT NULL,

   device_info TEXT,

   ip_address VARCHAR(100),

   device_hash VARCHAR(100),

   expired_at TIMESTAMP NOT NULL,

   revoked BOOLEAN NOT NULL DEFAULT FALSE,

   used BOOLEAN NOT NULL DEFAULT FALSE,

   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   CONSTRAINT fk_refresh_token_user
       FOREIGN KEY (user_id)
           REFERENCES iam.user_account(id)
           ON DELETE CASCADE

);

CREATE INDEX idx_refresh_token_token
    ON iam.refresh_token(token);

CREATE INDEX idx_refresh_token_user
    ON iam.refresh_token(user_id);

CREATE INDEX idx_refresh_token_session
    ON iam.refresh_token(session_id);

CREATE INDEX idx_refresh_token_expired
    ON iam.refresh_token(expired_at);