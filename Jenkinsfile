pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "viji2812/springboot-kyd-k8s"
        K8S_DEPLOYMENT = "spring-boot-app"
        K8S_NAMESPACE = "default"

        // Hardcoded credentials as requested
        DOCKER_USERNAME = "viji2812"
        DOCKER_PASSWORD = "ABCDviji@123"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Viji28/docker-devops-training-kyd.git'
            }
        }

        stage('Build & Package') {
            steps {
                bat "mvnw.cmd clean package -DskipTests || mvn clean package -DskipTests"
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %DOCKER_IMAGE%:latest ."
            }
        }

        stage('Login to Docker Hub') {
            steps {
                bat "docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%"
            }
        }

        stage('Push Image to Docker Hub') {
            steps {
                bat "docker push %DOCKER_IMAGE%:latest"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
        bat """

        //set kubectl path 
        set KUBECONFIG=c:\\Users\\Administrator\\.kube\\config
        echo Applying Deployment YAML...
        kubectl apply -f deployment.yaml

        echo Applying Service YAML...
        kubectl apply -f service.yaml

        echo Updating Deployment Image...
        kubectl set image deployment/%K8S_DEPLOYMENT% spring-boot-container=%DOCKER_IMAGE%:latest --namespace=%K8S_NAMESPACE%
        """
    }
        }
    }

    post {
        success {
            echo '✅ Deployment Successful!'
        }
        failure {
            echo '❌ Deployment Failed!'
        }
    }
}
