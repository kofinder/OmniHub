# Backend API Requirements From Existing Mock Data

## 1. Summary

The table below summaries all mock files, code data sources, and their corresponding APIs identified from the POS project:

| No | Feature/Module | Mock Source | Suggested Endpoint | Method | Auth Required | Status |
| -- | -------------- | ----------- | ------------------ | ------ | ------------- | ------ |
| 1  | Authentication | `MockAuthDataSource` | `/api/v1/auth/login` | POST | No | Need backend implementation |
| 2  | Device Management | `device_register_*.json` | `/api/v1/pos/devices/register-or-check` | POST | No | Need backend implementation |
| 3  | Tenant Configuration | `tenant_config_*.json` | `/api/v1/pos/config` | GET | Yes | Need backend implementation |
| 4  | Product Catalog | `products_pull_success.json` | `/api/v1/pos/products/pull` | GET | Yes | Need backend implementation |
| 5  | Inventory Management | `inventory_pull_success.json` | `/api/v1/pos/inventory/pull` | GET | Yes | Need backend implementation |
| 6  | Payment Gateways | `payment_gateway.json` | `/api/v1/pos/payment-gateways` | GET/POST/PUT/DELETE | Yes | Mock only |
| 7  | Customer Directory | `MockCustomerRemoteDataSource` | `/api/v1/pos/customers/sync` | POST | Yes | Need backend implementation |
| 8  | Sales & Syncing | `MockSalesRemoteDataSource` | `/api/v1/pos/sales/sync` | POST | Yes | Need backend implementation |
| 9  | Cash Movements | `MockCashMovementRemoteDataSource` | `/api/v1/pos/cash-movements/sync` | POST | Yes | Need backend implementation |

---

## 2. Endpoint Details

### Auth Login API

* **Related Module**: Authentication
* **Mock File / Source**: `MockAuthDataSource`
* **Current Usage In Flutter**: `AuthRemoteDataSource`, `AuthRepositoryImpl`, `AuthBloc`
* **Suggested Backend Endpoint**:
  * Method: `POST`
  * Endpoint: `/api/v1/auth/login`
  * Auth Requirement: None
  * Request Body: JSON payload containing email and password.
  * Response Body: SUCCESS format with authentication tokens.

### Device Register or Check API

* **Related Module**: Device Management
* **Mock File / Source**: `assets/mock/device_register_active.json`, `device_register_pending.json`, `device_register_blocked.json`
* **Current Usage In Flutter**: `DeviceRegisterRemoteDataSource`, `DeviceRepositoryImpl`, `DeviceBloc`
* **Suggested Backend Endpoint**:
  * Method: `POST`
  * Endpoint: `/api/v1/pos/devices/register-or-check`
  * Auth Requirement: None (uses hardware identifier)
  * Request Body: Device specification (UID, name, platform, model, OS, app version).
  * Response Body: Returns registration status (`active`, `pending`, `blocked`).

### Fetch Tenant Config API

* **Related Module**: Tenant Config
* **Mock File / Source**: `assets/mock/tenant_config_convenience.json`, `tenant_config_package_expired.json`, `tenant_config_config_expired.json`, `tenant_config_offline_verification_required.json`
* **Current Usage In Flutter**: `TenantConfigRemoteDataSource`, `TenantConfigRepositoryImpl`, `TenantConfigBloc`
* **Suggested Backend Endpoint**:
  * Method: `GET`
  * Endpoint: `/api/v1/pos/config`
  * Auth Requirement: Bearer Token
  * Query Parameters: None
  * Response Body: Complete package info, modules, settings, permissions, sync policy, and crypto signature.

### Pull Products Catalog API

* **Related Module**: Products
* **Mock File / Source**: `assets/mock/products_pull_success.json`
* **Current Usage In Flutter**: `ProductRemoteDataSource`, `ProductRepositoryImpl`, `ProductBloc`
* **Suggested Backend Endpoint**:
  * Method: `GET`
  * Endpoint: `/api/v1/pos/products/pull`
  * Auth Requirement: Bearer Token
  * Query Parameters:
    * `tenant_id` (string, required)
    * `last_pulled_at` (string, ISO8601, optional)
  * Response Body: Returns array of products and categories updated since `last_pulled_at`.

### Pull Inventory Snapshots API

* **Related Module**: Inventory
* **Mock File / Source**: `assets/mock/inventory_pull_success.json`
* **Current Usage In Flutter**: `InventoryRemoteDataSource`, `InventoryRepositoryImpl`, `InventoryBloc`
* **Suggested Backend Endpoint**:
  * Method: `GET`
  * Endpoint: `/api/v1/pos/inventory/pull`
  * Auth Requirement: Bearer Token
  * Query Parameters:
    * `tenant_id` (string, required)
    * `branch_id` (string, required)
    * `last_pulled_at` (string, ISO8601, optional)
  * Response Body: Returns list of stock levels for tracking.

### Payment Gateways CRUD APIs

* **Related Module**: Payment Gateways
* **Mock File / Source**: `assets/mock/payment_gateway.json` and `PaymentGatewayMockDatasource` code
* **Current Usage In Flutter**: `PaymentGatewayMockDatasource`, `PaymentGatewayRepositoryImpl`, `PaymentGatewayCubit`
* **Suggested Backend Endpoints**:
  * `GET /api/v1/pos/payment-gateways` (List all gateways)
  * `POST /api/v1/pos/payment-gateways` (Create gateway)
  * `PUT /api/v1/pos/payment-gateways/{id}` (Update gateway)
  * `DELETE /api/v1/pos/payment-gateways/{id}` (Delete gateway)
  * `PATCH /api/v1/pos/payment-gateways/{id}/toggle` (Toggle active/inactive status)
  * `PATCH /api/v1/pos/payment-gateways/{id}/default` (Set default gateway)
  * Auth Requirement: Bearer Token
  * Request Body / Responses: Custom JSON models based on existing structure.

### Customer Sync API

* **Related Module**: Customer Directory
* **Mock File / Source**: `MockCustomerRemoteDataSource`
* **Current Usage In Flutter**: `CustomerRemoteDataSource`, `CustomerRepositoryImpl`, `CustomerCubit`
* **Suggested Backend Endpoint**:
  * Method: `POST`
  * Endpoint: `/api/v1/pos/customers/sync`
  * Auth Requirement: Bearer Token
  * Request Body: Single customer details generated offline.
  * Response Body: Returns assigned server customer ID and sync timestamp.

### Sales Sync API

* **Related Module**: Sales & Checkouts
* **Mock File / Source**: `MockSalesRemoteDataSource`
* **Current Usage In Flutter**: `SalesRemoteDataSource`, `SalesRepositoryImpl`, `CartCubit`, `CheckoutCubit`, `SaleCubit`
* **Suggested Backend Endpoint**:
  * Method: `POST`
  * Endpoint: `/api/v1/pos/sales/sync`
  * Auth Requirement: Bearer Token
  * Request Body: Sale metadata, line items, and payments.
  * Response Body: Server sale ID and sync timestamp.

### Cash Movements Sync API

* **Related Module**: Cashier Session
* **Mock File / Source**: `MockCashMovementRemoteDataSource`
* **Current Usage In Flutter**: `CashMovementRemoteDataSource`, `CashierSessionRepositoryImpl`, `CashierSessionCubit`
* **Suggested Backend Endpoint**:
  * Method: `POST`
  * Endpoint: `/api/v1/pos/cash-movements/sync`
  * Auth Requirement: Bearer Token
  * Request Body: Session-linked cash movement details.
  * Response Body: Server cash movement ID and sync timestamp.

---

## 3. Request Specification

### Auth Login API Request
```json
{
  "email": "cashier@example.com",
  "password": "password"
}
```
| Field | Type | Required | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| email | string | yes | Cashier email credential | cashier@example.com |
| password | string | yes | Cashier password credential | password |

### Device Register or Check Request
```json
{
  "device_uid": "mock-device-uid",
  "device_name": "Counter 1",
  "platform": "macos",
  "model": "MacBookPro",
  "os_version": "14.4",
  "app_version": "1.0.0",
  "device_type": "mobile_pos"
}
```
| Field | Type | Required | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| device_uid | string | yes | Hardware unique ID | mock-device-uid |
| device_name | string | yes | Friendly name assigned to device | Counter 1 |
| platform | string | yes | Target OS / platform | macos / android / ios |
| model | string | yes | Hardware model name | MacBookPro |
| os_version | string | yes | OS version string | 14.4 |
| app_version | string | yes | Flutter application build version | 1.0.0 |
| device_type | string | yes | Constant representing device style | mobile_pos |

### Customer Sync Request
```json
{
  "customer": {
    "id": "cust_local_001",
    "tenant_id": "tenant_001",
    "branch_id": "branch_001",
    "code": "WALK_IN",
    "name": "Jane Doe",
    "phone": "091234567",
    "email": "jane@example.com",
    "address": "Yangon, Myanmar",
    "note": "Frequent customer",
    "is_active": true,
    "created_at": "2026-06-20T21:00:00Z",
    "updated_at": "2026-06-20T21:00:00Z"
  }
}
```
| Field | Type | Required | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| customer.id | string | yes | Local offline-generated UUID | cust_local_001 |
| customer.tenantId | string | yes | Target Business Tenant Identifier | tenant_001 |
| customer.branchId | string | no | Branch location ID | branch_001 |
| customer.code | string | no | Unique Customer Code / Loyalty Code | WALK_IN |
| customer.name | string | yes | Customer display name | Jane Doe |
| customer.phone | string | no | Phone number | 091234567 |
| customer.email | string | no | Email address | jane@example.com |
| customer.address | string | no | Mailing/billing address | Yangon |
| customer.note | string | no | Administrative notes | Frequent customer |
| customer.is_active | boolean | yes | Status flag | true |
| customer.created_at | string (date-time) | yes | Local creation ISO8601 | 2026-06-20T21:00:00Z |
| customer.updated_at | string (date-time) | yes | Local modification ISO8601 | 2026-06-20T21:00:00Z |

### Sales Sync Request
```json
{
  "sale": {
    "id": "sale_local_001",
    "tenant_id": "tenant_001",
    "branch_id": "branch_001",
    "device_id": "device_001",
    "user_id": "user_001",
    "customer_id": "cust_local_001",
    "customer_name": "Jane Doe",
    "sale_number": "SALE-1729000000000",
    "status": "completed",
    "subtotal": 1200.0,
    "discount_total": 0.0,
    "tax_total": 0.0,
    "grand_total": 1200.0,
    "payment_status": "paid",
    "sold_at": "2026-06-20T21:00:00Z",
    "created_at": "2026-06-20T21:00:00Z"
  },
  "items": [
    {
      "id": "item_local_001",
      "sale_id": "sale_local_001",
      "product_id": "prd_001",
      "product_name": "Coca-Cola 500ml",
      "sku": "COKE-500",
      "barcode": "8851959130012",
      "unit": "bottle",
      "quantity": 1.0,
      "unit_price": 1200.0,
      "discount_amount": 0.0,
      "subtotal": 1200.0,
      "total": 1200.0
    }
  ],
  "payments": [
    {
      "id": "pay_local_001",
      "sale_id": "sale_local_001",
      "method": "cash",
      "amount": 1200.0,
      "cash_received": 1500.0,
      "change_amount": 300.0,
      "status": "completed",
      "payment_gateway_id": "cash",
      "reference_no": null,
      "paid_at": "2026-06-20T21:00:00Z"
    }
  ]
}
```
| Field | Type | Required | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| sale.id | string | yes | Local offline UUID | sale_local_001 |
| sale.subtotal | number | yes | Sum of lines before discount | 1200.0 |
| sale.discount_total | number | yes | Sum of item discounts | 0.0 |
| sale.grand_total | number | yes | Total payable amount | 1200.0 |
| items[].product_id | string | yes | Product reference ID | prd_001 |
| items[].quantity | number | yes | Qty purchased | 1.0 |
| payments[].method | string | yes | payment type enum | cash / wallet / card |
| payments[].cash_received| number | yes | Cash handed by customer | 1500.0 |
| payments[].change_amount| number | yes | Change returned | 300.0 |

### Cash Movements Sync Request
```json
{
  "cash_movement": {
    "id": "move_local_001",
    "tenant_id": "tenant_001",
    "branch_id": "branch_001",
    "device_id": "device_001",
    "session_id": "session_local_001",
    "user_id": "user_001",
    "type": "cash_in",
    "amount": 50000.0,
    "reason": "Initial float",
    "note": "Drawer start",
    "created_at": "2026-06-20T21:00:00Z"
  }
}
```

---

## 4. Response Specification

### Standard Success Response
```json
{
  "status": "SUCCESS",
  "message": "Success",
  "data": {},
  "error": null
}
```

### Standard Error Response
```json
{
  "status": "ERROR",
  "message": "Validation failed",
  "data": null,
  "error": {
    "code": "FIELD_REQUIRED",
    "message": "The name field is required"
  }
}
```

### Auth Login Success Response
```json
{
  "status": "SUCCESS",
  "message": "Login successful",
  "data": {
    "access_token": "mock_access_token",
    "refresh_token": "mock_refresh_token",
    "token_type": "Bearer",
    "expires_in": 3600
  },
  "error": null
}
```

### Device Register Success Response
```json
{
  "status": "SUCCESS",
  "message": "Device registration state verified",
  "data": {
    "device": {
      "id": "device_001",
      "name": "Counter 1",
      "code": "POS-001",
      "device_uid": "mock-device-uid",
      "type": "mobile_pos",
      "status": "active",
      "branch_id": "branch_001"
    },
    "requires_approval": false
  },
  "error": null
}
```

### Tenant Config Success Response
```json
{
  "status": "SUCCESS",
  "message": "Tenant config loaded successfully",
  "signature": "signature_hash",
  "signature_algorithm": "ed25519",
  "key_id": "key_v1",
  "error": null,
  "data": {
    "tenant": {
      "id": "tenant_001",
      "name": "Golden Mart",
      "status": "active",
      "business_type": {
        "id": "business_type_001",
        "code": "convenience",
        "name": "Convenience Store"
      }
    },
    "branch": {
      "id": "branch_001",
      "name": "Main Branch",
      "code": "MAIN",
      "status": "active",
      "address": "Yangon, Myanmar"
    },
    "device": {
      "id": "device_001",
      "name": "Counter 1",
      "code": "POS-001",
      "device_uid": "demo-device-uid-001",
      "type": "mobile_pos",
      "status": "active",
      "branch_id": "branch_001"
    },
    "user": {
      "id": "user_001",
      "name": "Demo Cashier",
      "email": "cashier@example.com",
      "role": {
        "id": "role_001",
        "name": "Cashier",
        "code": "cashier"
      }
    },
    "package": {
      "id": "package_001",
      "code": "convenience_basic",
      "name": "Convenience Basic",
      "status": "active",
      "started_at": "2026-05-01T00:00:00Z",
      "expires_at": "2026-12-31T23:59:59Z"
    },
    "modules": [
      {
        "code": "sales",
        "name": "Sales",
        "enabled": true,
        "is_core": true
      }
    ],
    "permissions": [
      "dashboard.view",
      "sales.view",
      "sales.create",
      "sales.refund"
    ],
    "settings": {
      "allow_offline_sales": true,
      "offline_grace_days": 7,
      "allow_negative_stock": false,
      "default_currency": "MMK",
      "default_tax_enabled": false,
      "stock_method": "FIFO",
      "receipt_printing_enabled": true
    },
    "sync_policy": {
      "pull_interval_minutes": 15,
      "push_retry_limit": 5,
      "allow_background_sync": true,
      "require_online_verification_after_days": 7
    },
    "config": {
      "version": 1,
      "issued_at": "2026-05-27T00:00:00Z",
      "expires_at": "2026-06-30T00:00:00Z",
      "offline_grace_until": "2027-01-07T00:00:00Z"
    }
  }
}
```

### Products Pull Success Response
```json
{
  "status": "SUCCESS",
  "message": "Products loaded successfully",
  "data": {
    "categories": [
      {
        "id": "cat_001",
        "tenant_id": "tenant_001",
        "name": "Drinks",
        "code": "DRINKS",
        "parent_id": null,
        "sort_order": 1,
        "is_active": true,
        "updated_at": "2026-05-01T00:00:00Z",
        "synced_at": "2026-05-01T00:00:00Z"
      }
    ],
    "products": [
      {
        "id": "prd_001",
        "tenant_id": "tenant_001",
        "category_id": "cat_001",
        "name": "Coca-Cola 500ml",
        "image_url": "https://images.unsplash.com/photo-1629203851122-3726ecdf080e?auto=format&fit=crop&w=600&q=80",
        "sku": "COKE-500",
        "barcode": "8851959130012",
        "unit": "bottle",
        "cost_price": 800.0,
        "sale_price": 1200.0,
        "stock_tracking_enabled": true,
        "is_active": true,
        "updated_at": "2026-05-01T00:00:00Z",
        "synced_at": "2026-05-01T00:00:00Z"
      }
    ],
    "server_time": "2026-05-01T00:00:00Z"
  },
  "error": null
}
```

### Inventory Pull Success Response
```json
{
  "status": "SUCCESS",
  "message": "Inventory loaded successfully",
  "data": {
    "snapshots": [
      {
        "id": "inv_001",
        "tenant_id": "tenant_001",
        "branch_id": "branch_001",
        "product_id": "prd_001",
        "quantity_on_hand": 24.0,
        "reserved_quantity": 0.0,
        "available_quantity": 24.0,
        "low_stock_threshold": 5.0,
        "updated_at": "2026-05-01T00:00:00Z",
        "synced_at": "2026-05-01T00:00:00Z"
      }
    ],
    "server_time": "2026-05-01T00:00:00Z"
  },
  "error": null
}
```

### Sync Sync Confirmation Responses (Sales, Customers, Cash Movements)
* Customers:
```json
{
  "status": "SUCCESS",
  "message": "Customer synced successfully",
  "data": {
    "customer_id": "cust_local_001",
    "server_customer_id": "server_cust_local_001",
    "synced_at": "2026-06-20T21:01:00Z"
  },
  "error": null
}
```
* Sales:
```json
{
  "status": "SUCCESS",
  "message": "Sale synced successfully",
  "data": {
    "sale_id": "sale_local_001",
    "server_sale_id": "server_sale_local_001",
    "synced_at": "2026-06-20T21:01:00Z"
  },
  "error": null
}
```
* Cash Movements:
```json
{
  "status": "SUCCESS",
  "message": "Cash movement synced successfully",
  "data": {
    "cash_movement_id": "move_local_001",
    "server_cash_movement_id": "server_move_local_001",
    "synced_at": "2026-06-20T21:01:00Z"
  },
  "error": null
}
```

### Conflict Sync Response (Example)
```json
{
  "status": "ERROR",
  "message": "Conflict detected during synchronization",
  "code": "SALE_CONFLICT",
  "data": null,
  "error": "The sale number SALE-1729000000000 has already been registered."
}
```

---

## 5. Data Models

### ProductCategory
| Field | Type | Nullable | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| id | string | no | Unique category ID | `cat_001` |
| tenant_id | string | no | Business tenant identifier | `tenant_001` |
| name | string | no | Category display name | `Drinks` |
| code | string | yes | Short lookup code | `DRINKS` |
| parent_id | string | yes | Parent category ID for nesting | `null` |
| sort_order | integer | no | Display ordering weight | `1` |
| is_active | boolean | no | Active status flag | `true` |
| updated_at | string (date-time) | no | Modification timestamp | `2026-05-01T00:00:00Z` |
| synced_at | string (date-time) | yes | Server sync timestamp | `2026-05-01T00:00:00Z` |

### Product
| Field | Type | Nullable | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| id | string | no | Unique product ID | `prd_001` |
| tenant_id | string | no | Tenant identifier | `tenant_001` |
| category_id | string | yes | Category reference | `cat_001` |
| name | string | no | Product display name | `Coca-Cola 500ml` |
| image_url | string | yes | Public image link | `https://...` |
| sku | string | yes | Stock Keeping Unit | `COKE-500` |
| barcode | string | yes | UPC/EAN Barcode string | `8851959130012` |
| unit | string | no | Sales Unit measurement | `bottle` / `pack` / `pcs` |
| cost_price | number | no | Supply cost price | `800.0` |
| sale_price | number | no | Selling retail price | `1200.0` |
| stock_tracking_enabled | boolean | no | Track inventory stock | `true` |
| is_active | boolean | no | Status flag | `true` |
| updated_at | string (date-time) | no | Modification timestamp | `2026-05-01T00:00:00Z` |
| synced_at | string (date-time) | yes | Server sync timestamp | `2026-05-01T00:00:00Z` |

### InventorySnapshot
| Field | Type | Nullable | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| id | string | no | Unique stock entry ID | `inv_001` |
| tenant_id | string | no | Tenant identifier | `tenant_001` |
| branch_id | string | no | Branch location ID | `branch_001` |
| product_id | string | no | Reference to Product | `prd_001` |
| quantity_on_hand | number | no | Physical count in warehouse | `24.0` |
| reserved_quantity | number | no | Allocated to unfulfilled sales | `0.0` |
| available_quantity | number | no | Qty available for sale | `24.0` |
| low_stock_threshold | number | no | Point to alert low stock | `5.0` |
| updated_at | string (date-time) | no | Last updated timestamp | `2026-05-01T00:00:00Z` |
| synced_at | string (date-time) | yes | Sync timestamp | `2026-05-01T00:00:00Z` |

### PaymentGateway
| Field | Type | Nullable | Description | Example |
| ----- | ---- | -------- | ----------- | ------- |
| id | string | no | Gateway unique string | `cash` / `kbz_pay` |
| name | string | no | Gateway display name | `KBZ Pay` |
| code | string | no | Unique enum-code string | `kbz_pay` |
| type | string | no | Gateway type enum | `cash` / `mobile_wallet` / `bank_transfer` / `qr_payment` |
| provider_name | string | yes | Provider name | `KBZ Pay` |
| account_name | string | yes | Registered bank/wallet name | `Pocket POS Store` |
| account_number | string | yes | Bank Account Number | `null` |
| phone_number | string | yes | Mobile money wallet phone | `09XXXXXXXXX` |
| qr_image_url | string | yes | Dynamic QR code base URL | `null` |
| logo_url | string | yes | Logo image asset link | `null` |
| is_enabled | boolean | no | Active for checkout | `true` |
| is_default | boolean | no | Selection default at checkout | `false` |
| sort_order | integer | no | Display sorting sequence | `2` |
| config | object | yes | Key-value feature configuration | `{"supports_qr": true}` |
| created_at | string (date-time) | yes | Creation timestamp | `null` |
| updated_at | string (date-time) | yes | Update timestamp | `null` |

* **Enum Values for PaymentGatewayType**:
  * `cash`, `mobile_wallet`, `bank_transfer`, `qr_payment`, `card`, `custom`

---

## 6. CRUD Requirements

### Products Module
```http
GET    /api/v1/pos/products/pull?tenant_id={tenant_id}&last_pulled_at={last_pulled_at}
```

### Inventory Module
```http
GET    /api/v1/pos/inventory/pull?tenant_id={tenant_id}&branch_id={branch_id}&last_pulled_at={last_pulled_at}
```

### Customers Module
```http
POST   /api/v1/pos/customers/sync
```

### Sales Module
```http
POST   /api/v1/pos/sales/sync
```

### Cashiers & Sessions Module
```http
POST   /api/v1/pos/cash-movements/sync
```

### Payment Gateways Module
```http
GET    /api/v1/pos/payment-gateways
POST   /api/v1/pos/payment-gateways
PUT    /api/v1/pos/payment-gateways/{id}
DELETE /api/v1/pos/payment-gateways/{id}
PATCH  /api/v1/pos/payment-gateways/{id}/toggle
PATCH  /api/v1/pos/payment-gateways/{id}/default
```

---

## 7. Authentication and Permission Notes

### Target Permissions
Based on feature-specific permission definitions in Flutter, the following permissions should guard backend APIs:
* **Tenant Configuration**: `dashboard.view`
* **Sales Syncing**: `sales.create`, `sales.view`, `sales.refund`
* **Products Catalog**: `product.view`
* **Inventory Snapshots**: `inventory.view`
* **Payment Gateways Manager**:
  * `payment_gateway.view`
  * `payment_gateway.create`
  * `payment_gateway.update`
  * `payment_gateway.delete`
  * `payment_gateway.toggle`
  * `payment_gateway.set_default`

---

## 8. Backend Implementation Notes

1. **Offline-first Architecture Support**:
   * The client app records sales, customers, and cash movements offline when disconnected.
   * Sync requests use offline queueing. Client passes a client-side generated UUID (`id`) in requests.
   * The backend MUST store this client-generated ID as a cross-reference or primary key and return it in `customer_id`, `sale_id`, or `cash_movement_id` to confirm successful sync.
2. **Conflict Prevention Strategy**:
   * If a client tries to sync an entity ID that already exists on the server, backend should return standard `409 Conflict` (or JSON response with code `SALE_CONFLICT` / `CUSTOMER_CONFLICT`) instead of rewriting blindly.
3. **Data Protection & Configuration Security**:
   * Tenant configuration utilizes cryptographic verification.
   * Config fetches (`/api/v1/pos/config`) must optionally return a Ed25519 signature payload header:
     ```json
     "signature": "...",
     "signature_algorithm": "ed25519",
     "key_id": "..."
     ```
     This signature secures client settings verification offline.
4. **Soft Deletions**:
   * Products and categories should prioritize soft delete (`is_active` flag) instead of hard deletes, preventing sync crashes on offline clients who have referenced them in queued bills.

---

## 9. Missing or Unclear Information

| Area | Issue | Recommendation |
| ---- | ----- | -------------- |
| **Sales Voiding** | The repository invokes `voidLocalSale` which enqueues a void action with a separate payload layout (`sale_id`, `voided_at`). However, it hits the generic `/api/v1/pos/sales/sync` endpoint. | Confirm if voiding requires a separate endpoint like `POST /api/v1/pos/sales/{id}/void` or standard payload flag under sync. |
| **Payment Gateway CRUD** | The app supports CRUD on Payment Gateways but there are no backend endpoints defined for them in `ApiEndpoints`. | Define explicit REST resources `/api/v1/pos/payment-gateways` for CRUD instead of keeping it client-only. |
| **Branch / Tenant creation** | The app consumes Tenant Configuration but has no endpoints to modify config, business type, or branches. | Confirm if config changes are only modified via central web dashboard rather than the POS client. |

---

## 10. Final Backend API Checklist

* [ ] Implement `POST /api/v1/auth/login` (email/password check)
* [ ] Implement `POST /api/v1/pos/devices/register-or-check` (device validation/auth status check)
* [ ] Implement `GET /api/v1/pos/config` (loads complete Tenant settings & configuration with cryptographic signatures)
* [ ] Implement `GET /api/v1/pos/products/pull` (incremental pull based on `last_pulled_at`)
* [ ] Implement `GET /api/v1/pos/inventory/pull` (incremental inventory snapshots pull based on `last_pulled_at`)
* [ ] Implement `POST /api/v1/pos/customers/sync` (handles conflict states and maps client UUIDs to server IDs)
* [ ] Implement `POST /api/v1/pos/sales/sync` (processes order checkouts, invoices, and payments)
* [ ] Implement `POST /api/v1/pos/cash-movements/sync` (tracks cash flows per drawer session)
* [ ] Implement payment gateway REST endpoint resource suite (`GET`, `POST`, `PUT`, `DELETE`, status toggles)
* [ ] Set up Token authentication middleware verification on all routes except device registration and login.
* [ ] Set up scope/permission validation middleware on the endpoints.
