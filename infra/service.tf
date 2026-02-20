##################################################################
#################### CUSTOMER SERVICE ############################
##################################################################

locals {
  service_name          = "customer-service"
  service_manifest_path = "${path.module}/../k8s/base/${local.service_name}.yaml"
  service_manifest_raw  = file(local.service_manifest_path)
  
  # Substitui a tag da imagem usando regex
  service_manifest = replace(
    local.service_manifest_raw,
    "/(grecomilani/${local.service_name}:)[a-zA-Z0-9._-]+/",
    "grecomilani/${local.service_name}:${var.image_tag}"
  )
}

# Parse do manifesto (Service + Deployment)
data "kubectl_file_documents" "customer_service" {
  content = local.service_manifest
}

# Deploy do Customer Service
resource "kubectl_manifest" "customer_service" {
  for_each = data.kubectl_file_documents.customer_service.manifests

  yaml_body = each.value

  server_side_apply = true
  force_conflicts   = true
  wait              = true

  depends_on = [
    kubernetes_namespace.oficina,
    kubernetes_secret_v1.postgres_credentials
  ]
}
