     pipeline {
        agent any
        tools {
            maven 'maven'
        }
        stages {
            stage("Tools initialization"){
                steps{
                    sh 'maven --version'
                    sh 'java -version'
                }
            }
            stage("checkout code"){
                steps{
                    git branch: 'main',
                    url: "${https://github.com/festuge/main-library.git}"
                }
            }
            stage("to-test-maven"){
                steps{
                    sh 'mvn -v'
                }
            }
        }
    }
