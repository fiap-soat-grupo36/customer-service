terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "6.10.0"
    }
    kubernetes = {
      source  = "hashicorp/kubernetes"
      version = "~> 2.0"
    }
    kubectl = {
      source  = "gavinbunney/kubectl"
      version = ">= 1.19.0"
    }
    http = {
      source  = "hashicorp/http"
      version = "3.4.0"
    }
    helm = {
      source  = "hashicorp/helm"
      version = "2.16.1"
    }
    random = {
      source  = "hashicorp/random"
      version = "3.6"
    }
  }
}

provider "aws" {
  region = "us-east-1"

  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

  endpoints {
    ec2            = "http://localhost:4566"
    eks            = "http://localhost:4566"
    iam            = "http://localhost:4566"
    s3             = "http://localhost:4566"
    sts            = "http://localhost:4566"
    cloudformation = "http://localhost:4566"
  }
}

provider "kubernetes" {
  host                   = data.aws_eks_cluster.oficina.endpoint
  cluster_ca_certificate = base64decode(data.aws_eks_cluster.oficina.certificate_authority[0].data)
  token                  = data.aws_eks_cluster_auth.oficina.token
}


provider "kubectl" {
  host                   = data.aws_eks_cluster.oficina.endpoint
  cluster_ca_certificate = base64decode(data.aws_eks_cluster.oficina.certificate_authority[0].data)
  token                  = data.aws_eks_cluster_auth.oficina.token
  load_config_file       = false
}

provider "helm" {
  kubernetes {
    host                   = data.aws_eks_cluster.oficina.endpoint
    cluster_ca_certificate = base64decode(data.aws_eks_cluster.oficina.certificate_authority[0].data)
    token                  = data.aws_eks_cluster_auth.oficina.token
  }
}