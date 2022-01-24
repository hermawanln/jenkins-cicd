pipeline {
    agent any
    stages {
        stage('Docker Build') {
            steps {
                sh "docker build -t 192.168.1.100:5000/apps/njajal_pipeline:1 ."
            }
        }
        stage('Docker Publish') {
            steps {
                sh "docker push 192.168.1.100:5000/apps/njajal_pipeline:1"
            }
        }
        stage('Kubernetes Deploy') {
            steps {
                sh "helm install njajal ./jenkins-cicd"
            }
        }
    }
}