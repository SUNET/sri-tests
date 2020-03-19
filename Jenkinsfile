library identifier: 'shared-library@master', retriever: modernSCM(
  [$class: 'GitSCMSource',
   remote: 'git@github.com:emergya/ed-jenkins-shared-libraries.git',
   credentialsId: 'ed-cloud-ssh-key-id'])

pipeline {
    agent {
        kubernetes {
            yaml libraryResource('emergya/tribe-cloud/maven.yaml')
        }
    }
    environment {
        //PARAMETIZED URL_TO_SCAN
        //URL_TO_SCAN = "https://emergyadigital.com"
        REMOTEUSERNAMEKEY = "remoteUserKey"
        STORAGE_DESTINATION_PATH = "point-solutions-labs.appspot.com"
        STORAGE_SERVICE_ACCOUNT_ID = "point-solutions-labs-service-account"
    }

    options {
            buildDiscarder(logRotator(numToKeepStr:'5')) // Configura a 5 el número de ejecuciones de este job a mantener en el historial de jenkins
    }
    stages {
        // Placeholder
        stage('Example') {
            steps {
                container('maven') {
                    withCredentials([
                                string(credentialsId: 'remoteUserKey', variable: 'remoteUserKey'),
                                string(credentialsId: 'remoteUserName', variable: 'remoteUserName')
                        ]){
                            sh "mvn install '-DremoteUserKey=$remoteUserKey' '-DremoteUserName=$remoteUserName' "
                        }  
                }
            }
        }
    }
    // post {
    //     always {
    //         archiveArtifacts artifacts: 'build.properties', onlyIfSuccessful: true
    //     }
    // }
}