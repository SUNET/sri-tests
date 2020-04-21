properties([[$class: 'JiraProjectProperty'], parameters([
text(defaultValue: 'Windows 10,Firefox,73x64,1920x1080', description: '', name: 'remoteConfiguration'),
text(defaultValue: 'stage', description: '', name: 'environmentToTest')
])])

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
    // environment {
    // }

    options {
            buildDiscarder(logRotator(numToKeepStr:'5')) // Configura a 5 el número de ejecuciones de este job a mantener en el historial de jenkins
    }
    stages {
        // Placeholder
        stage('Mvn test') {
            steps {
                container('maven') {
                    script {
                    withCredentials([
                                string(credentialsId: 'remoteUserKey', variable: 'remoteUserKey'),
                                string(credentialsId: 'remoteUserName', variable: 'remoteUserName')
                        ]){
                            sh "mvn test '-DremoteUserKey=$remoteUserKey' '-DremoteUserName=$remoteUserName' '-DremoteConfiguration=$remoteConfiguration' package -P${environmentToTest}"
                        }  
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