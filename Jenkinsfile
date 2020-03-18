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
        stage('Example') {
            steps {
                container('maven') {
                    script {
                        // Steps
                        sh "mvn install"
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