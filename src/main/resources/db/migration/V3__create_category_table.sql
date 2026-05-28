insert ignore into `oauth_client_details`(`client_id`,`resource_ids`,`client_secret`,`scope`,`authorized_grant_types`,`web_server_redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`,`additional_information`,`autoapprove`) values ('jovian','resource-server-rest-api','$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha','read','password,authorization_code,refresh_token,client_credentials,implicit','https://www.getpostman.com/oauth2/callback','USER',10800,2592000,null,null);

insert ignore into `authorities`(`username`, `authority`) values ('admin', 'ROLE_USER');

insert ignore into `users`(`account_expired`,`account_locked`,`credentials_expired`,`enabled`,`password`,`username`,`email`,`phone_no`) values (0,0,0,1,'$2a$08$qvrzQZ7jJ7oy2p/msL4M0.l83Cd0jNsX6AJUitbgRXGzge4j035ha','admin','dfsfsdfs','admifdsfn');

insert ignore into `user_authority`(`authority_id`,`user_id`) values (1,1);