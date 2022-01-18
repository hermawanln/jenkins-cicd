### * To activate this feature, you'll need to install plugin "Job DSL" in Jenkins *

## How to Activate this Job DSL
1. Add build step
2. Choose "Process Job DSLs"
3. Choose "Look on Filsystem"
4. Fill the DSL Scripts with the path of .groovy script's DSL. For example in this project you can fill with ```job-dsl/dockerBuildPublish.groovy```.
5. You can start to build the project now.
6. After you, build for first time, there was an error with caused of ```ERROR: script not yet approved for use```
7. You need to approve the script with this following method :
    - Go to menu "Manage Jenkins".
    - Click "In-process Script Approval".
    - Approve Groovy script in this project.
    - Done, you can rebuild the project.

## Usable Link
1. https://jenkinsci.github.io/job-dsl-plugin/#method/javaposse.jobdsl.dsl.helpers.step.StepContext.dockerBuildAndPublish