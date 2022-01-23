pipeline {
    environment {
        // DEPLOY = "${env.BRANCH_NAME == "master" || env.BRANCH_NAME == "develop" ? "true" : "false"}"
        NAME = "jenkins-cicd"
        VERSION = '${GIT_REVISION,length=9}'
        REGISTRY = '192.168.1.100:5000/apps/jenkins-ci'
    }
    agent any
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