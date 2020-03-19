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
                    withCredentials([usernamePassword(credentialsId: 'd1147c5d-40af-4c2e-a3ae-4ac4b3e9c3ca', passwordVariable: 'remoteUserKey', usernameVariable: 'remoteUserName')]) {
                        // Steps  
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