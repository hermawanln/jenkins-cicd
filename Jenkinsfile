pipeline {
    agent any
    environment {
        NAME = "jenkins-cicd"
        VERSION = '${GIT_REVISION,length=9}'
        REGISTRY = '192.168.1.100:5000/apps/njajal_pipeline'
    }
    stages {
        stage('Docker Build') {
            steps {
                sh "docker build -t ${REGISTRY}:${VERSION} ."
            }
        }
        stage('Docker Publish') {
            steps {
                sh "docker push ${REGISTRY}:${VERSION}"
            }
        }
        stage('Kubernetes Deploy') {
            steps {
                sh "helm upgrade --install --force --set name=${NAME} --set image.tag=${VERSION} ${NAME} ./jenkins-cicd"
            }
        }
    }
}