job('jenkins-cicd-deploy') {
    scm {
        git('https://github.com/hermawanln/jenkins-cicd.git') {  node ->
            node / gitConfigName('hermawanln')
            node / gitConfigEmail('hermawan.luthfi@gmail.com')
        }
    }
    triggers {
        scm('* * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('apps/jenkins-test')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}') //unique id dari git yang digunakan untuk auto generate SHA 
            // registryCredentials('dockerhub')
            // dockerHostURI('unix:///var/run/docker.sock') // Specifies the URI to the Docker host.
            dockerRegistryURL('http://192.168.1.100:5000/') // Sets the URL of the Docker registry.
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}