# dockerTests
DockerTestCases
Steps to run the test cases in Docker
1. Take the pull of selenium hub and node browsers image in docker
docker pull selenium/hub
docker pull selenium/node-firefox
docker pull selenium/node-chrome
docker pull selenium/node-firefox-debug
docker pull selenium/node-chrome-debug

2. Debug node is used to view the running test cases in VNC Viewer

3. Start the hub by using the command 
docker run -d -p 4444:4444 --name selenium-hub selenium/hub

4. Start the nodes
docker run -d -P --link selenium-hub:hub selenium/node-chrome-debug

docker run -d -P --link selenium-hub:hub selenium/node-firefox-debug
