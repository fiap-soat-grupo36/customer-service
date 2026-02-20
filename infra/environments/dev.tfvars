region    = "us-east-1"

# Service Configuration
service_name = "customer-service"  # Altere para o serviço do repositório atual

# RDS Configuration
rds_identifier    = "fiap-rds"
rds_database_name =  "customer-service-dev"

# AWS Secrets Manager Configuration
secrets_manager_jwt_secret_name   = "jwt_secret"
secrets_manager_email_secret_name = "email_credentials"