## testcontainers-java-mysql-graalvm-native-test

- For https://github.com/apache/shardingsphere/pull/29357 .

- `mysql-default-conf/` is from https://github.com/testcontainers/testcontainers-java/blob/1.19.3/modules/mysql/src/main/resources/mysql-default-conf/my.cnf .

- Execute the following command on the Ubuntu 22.04.3 LTS instance with `SDKMAN!`.
```shell
sdk install java 17.0.9-graalce
sdk use java 17.0.9-graalce
sudo apt-get install build-essential libz-dev zlib1g-dev

git clone git@github.com:linghengqian/testcontainers-java-mysql-graalvm-native-test.git
cd ./testcontainers-java-mysql-graalvm-native-test/
./gradlew -Pagent clean test
./gradlew metadataCopy --task test
./gradlew clean nativeTest
```

- The Log is as follows.
```shell
$ ./gradlew clean nativeTest

> Task :generateTestResourcesConfigFile
[native-image-plugin] Resources configuration written into /home/linghengqian/TwinklingLiftWorks/git/public/testcontainers-java-mysql-graalvm-native-test/build/native/generated/generateTestResourcesConfigFile/resource-config.json

> Task :nativeTestCompile
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: JAVA_HOME
[native-image-plugin] Native Image executable path: /home/linghengqian/.sdkman/candidates/java/17.0.9-graalce/lib/svm/bin/native-image
========================================================================================================================
GraalVM Native Image: Generating 'testcontainers-java-mysql-graalvm-native-test-tests' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
Warning: Method sun.security.provider.NativePRNG.<init>(SecureRandomParameters) not found.
Warning: Method sun.security.provider.NativePRNG$NonBlocking.<init>(SecureRandomParameters) not found.
[1/8] Initializing...                                                                                   (11.1s @ 0.15GB)
 Java version: 17.0.9+9, vendor version: GraalVM CE 17.0.9+9.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s)
 - org.graalvm.junit.platform.JUnitPlatformFeature
[junit-platform-native] Running in 'test listener' mode using files matching pattern [junit-platform-unique-ids*] found in folder [/home/linghengqian/TwinklingLiftWorks/git/public/testcontainers-java-mysql-graalvm-native-test/build/test-results/test/testlist] and its subfolders.
[2/8] Performing analysis...  [*******]                                                                 (73.6s @ 1.53GB)
  13,428 (88.64%) of 15,149 types reachable
  24,229 (65.80%) of 36,822 fields reachable
  65,889 (58.05%) of 113,498 methods reachable
   4,279 types, 1,437 fields, and 4,143 methods registered for reflection
      99 types,   115 fields, and   100 methods registered for JNI access
       4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                              (11.3s @ 1.77GB)
[4/8] Parsing methods...      [***]                                                                      (5.4s @ 2.38GB)
[5/8] Inlining methods...     [***]                                                                      (2.9s @ 1.67GB)
[6/8] Compiling methods...    [*******]                                                                 (50.5s @ 2.74GB)
[7/8] Layouting methods...    [**]                                                                       (5.0s @ 2.21GB)
[8/8] Creating image...       [***]                                                                      (5.7s @ 2.86GB)
  32.93MB (50.20%) for code area:    42,022 compilation units
  30.34MB (46.24%) for image heap:  332,420 objects and 89 resources
   2.33MB ( 3.56%) for other data
  65.61MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
  12.60MB java.base                                            7.06MB byte[] for code metadata
   5.04MB testcontainers-1.19.3.jar                            3.25MB java.lang.String
   3.78MB java.xml                                             3.19MB java.lang.Class
   2.63MB mysql-connector-j-8.0.31.jar                         2.85MB byte[] for general heap data
   1.31MB postgresql-42.4.3.jar                                2.78MB byte[] for java.lang.String
   1.24MB svm.jar (Native Image)                               1.71MB byte[] for embedded resources
 863.54kB docker-java-transport-zerodep-3.3.4.jar              1.13MB com.oracle.svm.core.hub.DynamicHubCompanion
 599.74kB java.security.jgss                                 856.17kB byte[] for reflection metadata
 477.35kB java.management                                    692.66kB java.lang.String[]
 463.66kB jna-5.13.0.jar                                     569.34kB java.util.HashMap$Node
   3.69MB for 53 more packages                                 5.30MB for 2862 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                        13.3s (7.9% of total time) in 86 GCs | Peak RSS: 4.28GB | CPU load: 4.95
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /home/linghengqian/TwinklingLiftWorks/git/public/testcontainers-java-mysql-graalvm-native-test/build/native/nativeTestCompile/testcontainers-java-mysql-graalvm-native-test-tests (executable)
========================================================================================================================
Finished generating 'testcontainers-java-mysql-graalvm-native-test-tests' in 2m 46s.
[native-image-plugin] Native Image written to: /home/linghengqian/TwinklingLiftWorks/git/public/testcontainers-java-mysql-graalvm-native-test/build/native/nativeTestCompile

> Task :nativeTest
JUnit Platform on Native Image - report
----------------------------------------

Starting MySQL ...
[awaitility-thread] INFO org.testcontainers.images.PullPolicy - Image pull policy will be performed by: DefaultPullPolicy()
[awaitility-thread] INFO org.testcontainers.utility.ImageNameSubstitutor - Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
[awaitility-thread] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
[awaitility-thread] INFO org.testcontainers.dockerclient.DockerClientProviderStrategy - Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
[awaitility-thread] INFO org.testcontainers.DockerClientFactory - Docker host IP address is localhost
[awaitility-thread] INFO org.testcontainers.DockerClientFactory - Connected to docker: 
  Server Version: 24.0.6
  API Version: 1.43
  Operating System: Docker Desktop
  Total Memory: 12974 MB
[awaitility-thread] INFO tc.testcontainers/ryuk:0.5.1 - Creating container for image: testcontainers/ryuk:0.5.1
[awaitility-thread] INFO org.testcontainers.utility.RegistryAuthLocator - Credential helper/store (docker-credential-desktop.exe) does not have credentials for https://index.docker.io/v1/
[awaitility-thread] INFO tc.testcontainers/ryuk:0.5.1 - Container testcontainers/ryuk:0.5.1 is starting: 8adeb0c17ce7b9f424e1a72349587c74aa68dc1afc7371e5a188952d5667d44e
[awaitility-thread] INFO tc.testcontainers/ryuk:0.5.1 - Container testcontainers/ryuk:0.5.1 started in PT0.608204S
[awaitility-thread] INFO org.testcontainers.utility.RyukResourceReaper - Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
[awaitility-thread] INFO org.testcontainers.DockerClientFactory - Checking the system...
[awaitility-thread] INFO org.testcontainers.DockerClientFactory - ✔︎ Docker server version should be at least 1.6.0
[awaitility-thread] INFO tc.mysql:8.2.0-oracle - Creating container for image: mysql:8.2.0-oracle
[awaitility-thread] INFO tc.mysql:8.2.0-oracle - Container mysql:8.2.0-oracle is starting: 1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f
[awaitility-thread] ERROR tc.mysql:8.2.0-oracle - Could not start container
org.testcontainers.shaded.org.awaitility.core.ConditionTimeoutException: org.testcontainers.containers.GenericContainer expected the predicate to return <true> but it returned <false> for input of <InspectContainerResponse(args=[mysqld], config=ContainerConfig(attachStderr=false, attachStdin=false, attachStdout=false, cmd=[mysqld], domainName=, entrypoint=[docker-entrypoint.sh], env=[MYSQL_DATABASE=demo_ds_0, MYSQL_ALLOW_EMPTY_PASSWORD=yes, PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin, GOSU_VERSION=1.16, MYSQL_MAJOR=innovation, MYSQL_VERSION=8.2.0-1.el8, MYSQL_SHELL_VERSION=8.0.35-1.el8], exposedPorts=[3306/tcp, 33060/tcp], hostName=1b443d3d6585, image=mysql:8.2.0-oracle, labels={desktop.docker.io/wsl-distro=Ubuntu-22.04, org.testcontainers=true, org.testcontainers.lang=java, org.testcontainers.sessionId=c93531a3-df52-4c46-a0cb-341b10f4704a, org.testcontainers.version=1.19.3}, macAddress=null, networkDisabled=null, onBuild=null, stdinOpen=false, portSpecs=null, stdInOnce=false, tty=false, user=, volumes={/var/lib/mysql={}}, workingDir=, healthCheck=null), created=2023-12-12T06:39:33.479856137Z, driver=overlay2, execDriver=null, hostConfig=HostConfig(binds=[], blkioWeight=0, blkioWeightDevice=null, blkioDeviceReadBps=null, blkioDeviceWriteBps=null, blkioDeviceReadIOps=null, blkioDeviceWriteIOps=null, memorySwappiness=null, nanoCPUs=0, capAdd=null, capDrop=null, containerIDFile=, cpuPeriod=0, cpuRealtimePeriod=0, cpuRealtimeRuntime=0, cpuShares=0, cpuQuota=0, cpusetCpus=, cpusetMems=, devices=null, deviceCgroupRules=null, deviceRequests=null, diskQuota=null, dns=null, dnsOptions=null, dnsSearch=null, extraHosts=[], groupAdd=null, ipcMode=shareable, cgroup=, links=[], logConfig=LogConfig(type=json-file, config={}), lxcConf=null, memory=0, memorySwap=0, memoryReservation=0, kernelMemory=null, networkMode=default, oomKillDisable=false, init=null, autoRemove=false, oomScoreAdj=0, portBindings={3306/tcp=[Lcom.github.dockerjava.api.model.Ports$Binding;@6363f9e3}, privileged=false, publishAllPorts=false, readonlyRootfs=false, restartPolicy=no, ulimits=null, cpuCount=0, cpuPercent=0, ioMaximumIOps=0, ioMaximumBandwidth=0, volumesFrom=[], mounts=null, pidMode=, isolation=null, securityOpts=null, storageOpt=null, cgroupParent=, volumeDriver=, shmSize=67108864, pidsLimit=null, runtime=runc, tmpFs=null, utSMode=, usernsMode=, sysctls=null, consoleSize=[0, 0], cgroupnsMode=host), hostnamePath=/var/lib/docker/containers/1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f/hostname, hostsPath=/var/lib/docker/containers/1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f/hosts, logPath=/var/lib/docker/containers/1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f/1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f-json.log, id=1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f, sizeRootFs=null, sizeRw=null, imageId=sha256:f7fdab215ab77d3c9f93d4a1afa4b77850bc1b1ed1372ffe31b96ad9cd78a07e, mountLabel=, name=/friendly_chatterjee, restartCount=0, networkSettings=NetworkSettings(bridge=, sandboxId=5db52b11a2f1b918ec33d5e000ab7145120628f73f62746facf8841103635e48, hairpinMode=false, linkLocalIPv6Address=, linkLocalIPv6PrefixLen=0, ports={}, sandboxKey=/var/run/docker/netns/5db52b11a2f1, secondaryIPAddresses=null, secondaryIPv6Addresses=null, endpointID=, gateway=, portMapping=null, globalIPv6Address=, globalIPv6PrefixLen=0, ipAddress=, ipPrefixLen=0, ipV6Gateway=, macAddress=, networks={bridge=ContainerNetwork(ipamConfig=null, links=[], aliases=null, networkID=16a6f18c4fec0552a4a69227ea0174e7b1b613d2507f47aaa9cadce7a13ed643, endpointId=, gateway=, ipAddress=, ipPrefixLen=0, ipV6Gateway=, globalIPv6Address=, globalIPv6PrefixLen=0, macAddress=)}), path=docker-entrypoint.sh, processLabel=, resolvConfPath=/var/lib/docker/containers/1b443d3d658568f31c47a3d2290659d242e051140348eef223ce0d5043f1bc2f/resolv.conf, execIds=null, state=InspectContainerResponse.ContainerState(status=exited, running=false, paused=false, restarting=false, oomKilled=false, dead=false, pid=0, exitCode=1, error=, startedAt=2023-12-12T06:39:33.838228369Z, finishedAt=2023-12-12T06:39:33.861460867Z, health=null), volumes=null, volumesRW=null, node=null, mounts=[InspectContainerResponse.Mount(name=ad7b0e4e98b11b09042d806720b140670da68ea7b648e4e330d674305cd4ab01, source=/var/lib/docker/volumes/ad7b0e4e98b11b09042d806720b140670da68ea7b648e4e330d674305cd4ab01/_data, destination=/var/lib/mysql, driver=local, mode=, rw=true)], graphDriver=GraphDriver(name=overlay2, data=GraphData(rootDir=null, deviceId=null, deviceName=null, deviceSize=null, dir=null)), platform=linux)> within 5 seconds.
        at org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:167)
        at org.testcontainers.shaded.org.awaitility.core.AbstractHamcrestCondition.await(AbstractHamcrestCondition.java:86)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:985)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:691)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:708)
        at org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:469)
        at org.testcontainers.containers.GenericContainer.lambda$doStart$0(GenericContainer.java:357)
        at org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:81)
        at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:347)
        at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:333)
        at org.testcontainers.jdbc.ContainerDatabaseDriver.connect(ContainerDatabaseDriver.java:134)
        at java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:681)
        at java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:190)
        at com.lingh.MySQLAndPostgresTest.openConnectionInMySQL(MySQLAndPostgresTest.java:35)
        at com.lingh.MySQLAndPostgresTest.lambda$testMySQL$1(MySQLAndPostgresTest.java:22)
        at org.awaitility.core.CallableCondition$ConditionEvaluationWrapper.eval(CallableCondition.java:99)
        at org.awaitility.core.ConditionAwaiter$ConditionPoller.call(ConditionAwaiter.java:248)
        at org.awaitility.core.ConditionAwaiter$ConditionPoller.call(ConditionAwaiter.java:235)
        at java.base@17.0.9/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base@17.0.9/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base@17.0.9/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base@17.0.9/java.lang.Thread.run(Thread.java:840)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:807)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:210)
Caused by: org.testcontainers.shaded.org.awaitility.core.DeadlockException: Deadlocked threads detected:


        at org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:159)
        ... 23 more
[awaitility-thread] ERROR tc.mysql:8.2.0-oracle - Log output from the failed container:
2023-12-12 06:39:33+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.2.0-1.el8 started.
2023-12-12 06:39:33+00:00 [ERROR] [Entrypoint]: mysqld failed while attempting to check config
        command was: mysqld --verbose --help --log-bin-index=/tmp/tmp.lKSuNE0pgs
        mysqld: Can't read dir of '/etc/mysql/conf.d/' (OS errno 20 - Not a directory)
mysqld: [ERROR] Stopped processing the 'includedir' directive in file /etc/my.cnf at line 36.
mysqld: [ERROR] Fatal error in defaults handling. Program aborted!

[awaitility-thread] INFO tc.mysql:8.2.0-oracle - Creating container for image: mysql:8.2.0-oracle
[awaitility-thread] INFO tc.mysql:8.2.0-oracle - Container mysql:8.2.0-oracle is starting: b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c
[awaitility-thread] ERROR tc.mysql:8.2.0-oracle - Could not start container
org.testcontainers.shaded.org.awaitility.core.ConditionTimeoutException: org.testcontainers.containers.GenericContainer expected the predicate to return <true> but it returned <false> for input of <InspectContainerResponse(args=[mysqld], config=ContainerConfig(attachStderr=false, attachStdin=false, attachStdout=false, cmd=[mysqld], domainName=, entrypoint=[docker-entrypoint.sh], env=[MYSQL_DATABASE=demo_ds_0, MYSQL_ALLOW_EMPTY_PASSWORD=yes, PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin, GOSU_VERSION=1.16, MYSQL_MAJOR=innovation, MYSQL_VERSION=8.2.0-1.el8, MYSQL_SHELL_VERSION=8.0.35-1.el8], exposedPorts=[3306/tcp, 33060/tcp], hostName=b1ad7fa51f8d, image=mysql:8.2.0-oracle, labels={desktop.docker.io/wsl-distro=Ubuntu-22.04, org.testcontainers=true, org.testcontainers.lang=java, org.testcontainers.sessionId=c93531a3-df52-4c46-a0cb-341b10f4704a, org.testcontainers.version=1.19.3}, macAddress=null, networkDisabled=null, onBuild=null, stdinOpen=false, portSpecs=null, stdInOnce=false, tty=false, user=, volumes={/var/lib/mysql={}}, workingDir=, healthCheck=null), created=2023-12-12T06:39:38.908580198Z, driver=overlay2, execDriver=null, hostConfig=HostConfig(binds=[], blkioWeight=0, blkioWeightDevice=null, blkioDeviceReadBps=null, blkioDeviceWriteBps=null, blkioDeviceReadIOps=null, blkioDeviceWriteIOps=null, memorySwappiness=null, nanoCPUs=0, capAdd=null, capDrop=null, containerIDFile=, cpuPeriod=0, cpuRealtimePeriod=0, cpuRealtimeRuntime=0, cpuShares=0, cpuQuota=0, cpusetCpus=, cpusetMems=, devices=null, deviceCgroupRules=null, deviceRequests=null, diskQuota=null, dns=null, dnsOptions=null, dnsSearch=null, extraHosts=[], groupAdd=null, ipcMode=shareable, cgroup=, links=[], logConfig=LogConfig(type=json-file, config={}), lxcConf=null, memory=0, memorySwap=0, memoryReservation=0, kernelMemory=null, networkMode=default, oomKillDisable=false, init=null, autoRemove=false, oomScoreAdj=0, portBindings={3306/tcp=[Lcom.github.dockerjava.api.model.Ports$Binding;@251ee63}, privileged=false, publishAllPorts=false, readonlyRootfs=false, restartPolicy=no, ulimits=null, cpuCount=0, cpuPercent=0, ioMaximumIOps=0, ioMaximumBandwidth=0, volumesFrom=[], mounts=null, pidMode=, isolation=null, securityOpts=null, storageOpt=null, cgroupParent=, volumeDriver=, shmSize=67108864, pidsLimit=null, runtime=runc, tmpFs=null, utSMode=, usernsMode=, sysctls=null, consoleSize=[0, 0], cgroupnsMode=host), hostnamePath=/var/lib/docker/containers/b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c/hostname, hostsPath=/var/lib/docker/containers/b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c/hosts, logPath=/var/lib/docker/containers/b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c/b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c-json.log, id=b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c, sizeRootFs=null, sizeRw=null, imageId=sha256:f7fdab215ab77d3c9f93d4a1afa4b77850bc1b1ed1372ffe31b96ad9cd78a07e, mountLabel=, name=/gifted_shockley, restartCount=0, networkSettings=NetworkSettings(bridge=, sandboxId=7eceb00c08a0388655654126cbd8e4b861b279df969a64d1628cdd847da34d4a, hairpinMode=false, linkLocalIPv6Address=, linkLocalIPv6PrefixLen=0, ports={}, sandboxKey=/var/run/docker/netns/7eceb00c08a0, secondaryIPAddresses=null, secondaryIPv6Addresses=null, endpointID=, gateway=, portMapping=null, globalIPv6Address=, globalIPv6PrefixLen=0, ipAddress=, ipPrefixLen=0, ipV6Gateway=, macAddress=, networks={bridge=ContainerNetwork(ipamConfig=null, links=[], aliases=null, networkID=16a6f18c4fec0552a4a69227ea0174e7b1b613d2507f47aaa9cadce7a13ed643, endpointId=, gateway=, ipAddress=, ipPrefixLen=0, ipV6Gateway=, globalIPv6Address=, globalIPv6PrefixLen=0, macAddress=)}), path=docker-entrypoint.sh, processLabel=, resolvConfPath=/var/lib/docker/containers/b1ad7fa51f8d2e00bb01fa0da20d0579b573d20a1b695c0d001b05373c2b287c/resolv.conf, execIds=null, state=InspectContainerResponse.ContainerState(status=exited, running=false, paused=false, restarting=false, oomKilled=false, dead=false, pid=0, exitCode=1, error=, startedAt=2023-12-12T06:39:39.418347169Z, finishedAt=2023-12-12T06:39:39.440103161Z, health=null), volumes=null, volumesRW=null, node=null, mounts=[InspectContainerResponse.Mount(name=2e25f5734c62442d4b853ad77222819393182a4c5622f2611fae16438012ccfe, source=/var/lib/docker/volumes/2e25f5734c62442d4b853ad77222819393182a4c5622f2611fae16438012ccfe/_data, destination=/var/lib/mysql, driver=local, mode=, rw=true)], graphDriver=GraphDriver(name=overlay2, data=GraphData(rootDir=null, deviceId=null, deviceName=null, deviceSize=null, dir=null)), platform=linux)> within 5 seconds.
        at org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:167)
        at org.testcontainers.shaded.org.awaitility.core.AbstractHamcrestCondition.await(AbstractHamcrestCondition.java:86)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:985)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:691)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:708)
        at org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:469)
        at org.testcontainers.containers.GenericContainer.lambda$doStart$0(GenericContainer.java:357)
        at org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:81)
        at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:347)
        at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:333)
        at org.testcontainers.jdbc.ContainerDatabaseDriver.connect(ContainerDatabaseDriver.java:134)
        at java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:681)
        at java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:190)
        at com.lingh.MySQLAndPostgresTest.openConnectionInMySQL(MySQLAndPostgresTest.java:35)
        at com.lingh.MySQLAndPostgresTest.lambda$testMySQL$1(MySQLAndPostgresTest.java:22)
        at org.awaitility.core.CallableCondition$ConditionEvaluationWrapper.eval(CallableCondition.java:99)
        at org.awaitility.core.ConditionAwaiter$ConditionPoller.call(ConditionAwaiter.java:248)
        at org.awaitility.core.ConditionAwaiter$ConditionPoller.call(ConditionAwaiter.java:235)
        at java.base@17.0.9/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base@17.0.9/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base@17.0.9/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base@17.0.9/java.lang.Thread.run(Thread.java:840)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:807)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:210)
Caused by: org.testcontainers.shaded.org.awaitility.core.DeadlockException: Deadlocked threads detected:


        at org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:159)
        ... 23 more
[awaitility-thread] ERROR tc.mysql:8.2.0-oracle - Log output from the failed container:
2023-12-12 06:39:39+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.2.0-1.el8 started.
2023-12-12 06:39:39+00:00 [ERROR] [Entrypoint]: mysqld failed while attempting to check config
        command was: mysqld --verbose --help --log-bin-index=/tmp/tmp.48sKPSFZg6
        mysqld: Can't read dir of '/etc/mysql/conf.d/' (OS errno 20 - Not a directory)
mysqld: [ERROR] Stopped processing the 'includedir' directive in file /etc/my.cnf at line 36.
mysqld: [ERROR] Fatal error in defaults handling. Program aborted!

[awaitility-thread] INFO tc.mysql:8.2.0-oracle - Creating container for image: mysql:8.2.0-oracle
[awaitility-thread] INFO tc.mysql:8.2.0-oracle - Container mysql:8.2.0-oracle is starting: 505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864
[awaitility-thread] ERROR tc.mysql:8.2.0-oracle - Could not start container
org.testcontainers.shaded.org.awaitility.core.ConditionTimeoutException: org.testcontainers.containers.GenericContainer expected the predicate to return <true> but it returned <false> for input of <InspectContainerResponse(args=[mysqld], config=ContainerConfig(attachStderr=false, attachStdin=false, attachStdout=false, cmd=[mysqld], domainName=, entrypoint=[docker-entrypoint.sh], env=[MYSQL_DATABASE=demo_ds_0, MYSQL_ALLOW_EMPTY_PASSWORD=yes, PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin, GOSU_VERSION=1.16, MYSQL_MAJOR=innovation, MYSQL_VERSION=8.2.0-1.el8, MYSQL_SHELL_VERSION=8.0.35-1.el8], exposedPorts=[3306/tcp, 33060/tcp], hostName=505197496ada, image=mysql:8.2.0-oracle, labels={desktop.docker.io/wsl-distro=Ubuntu-22.04, org.testcontainers=true, org.testcontainers.lang=java, org.testcontainers.sessionId=c93531a3-df52-4c46-a0cb-341b10f4704a, org.testcontainers.version=1.19.3}, macAddress=null, networkDisabled=null, onBuild=null, stdinOpen=false, portSpecs=null, stdInOnce=false, tty=false, user=, volumes={/var/lib/mysql={}}, workingDir=, healthCheck=null), created=2023-12-12T06:39:44.476948482Z, driver=overlay2, execDriver=null, hostConfig=HostConfig(binds=[], blkioWeight=0, blkioWeightDevice=null, blkioDeviceReadBps=null, blkioDeviceWriteBps=null, blkioDeviceReadIOps=null, blkioDeviceWriteIOps=null, memorySwappiness=null, nanoCPUs=0, capAdd=null, capDrop=null, containerIDFile=, cpuPeriod=0, cpuRealtimePeriod=0, cpuRealtimeRuntime=0, cpuShares=0, cpuQuota=0, cpusetCpus=, cpusetMems=, devices=null, deviceCgroupRules=null, deviceRequests=null, diskQuota=null, dns=null, dnsOptions=null, dnsSearch=null, extraHosts=[], groupAdd=null, ipcMode=shareable, cgroup=, links=[], logConfig=LogConfig(type=json-file, config={}), lxcConf=null, memory=0, memorySwap=0, memoryReservation=0, kernelMemory=null, networkMode=default, oomKillDisable=false, init=null, autoRemove=false, oomScoreAdj=0, portBindings={3306/tcp=[Lcom.github.dockerjava.api.model.Ports$Binding;@450fdbcf}, privileged=false, publishAllPorts=false, readonlyRootfs=false, restartPolicy=no, ulimits=null, cpuCount=0, cpuPercent=0, ioMaximumIOps=0, ioMaximumBandwidth=0, volumesFrom=[], mounts=null, pidMode=, isolation=null, securityOpts=null, storageOpt=null, cgroupParent=, volumeDriver=, shmSize=67108864, pidsLimit=null, runtime=runc, tmpFs=null, utSMode=, usernsMode=, sysctls=null, consoleSize=[0, 0], cgroupnsMode=host), hostnamePath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/hostname, hostsPath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/hosts, logPath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864-json.log, id=505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864, sizeRootFs=null, sizeRw=null, imageId=sha256:f7fdab215ab77d3c9f93d4a1afa4b77850bc1b1ed1372ffe31b96ad9cd78a07e, mountLabel=, name=/charming_neumann, restartCount=0, networkSettings=NetworkSettings(bridge=, sandboxId=f0e7e05097f04cf15f028cda637dea942ec232f5142c3b8aa67a1399dc6697af, hairpinMode=false, linkLocalIPv6Address=, linkLocalIPv6PrefixLen=0, ports={}, sandboxKey=/var/run/docker/netns/f0e7e05097f0, secondaryIPAddresses=null, secondaryIPv6Addresses=null, endpointID=, gateway=, portMapping=null, globalIPv6Address=, globalIPv6PrefixLen=0, ipAddress=, ipPrefixLen=0, ipV6Gateway=, macAddress=, networks={bridge=ContainerNetwork(ipamConfig=null, links=[], aliases=null, networkID=16a6f18c4fec0552a4a69227ea0174e7b1b613d2507f47aaa9cadce7a13ed643, endpointId=, gateway=, ipAddress=, ipPrefixLen=0, ipV6Gateway=, globalIPv6Address=, globalIPv6PrefixLen=0, macAddress=)}), path=docker-entrypoint.sh, processLabel=, resolvConfPath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/resolv.conf, execIds=null, state=InspectContainerResponse.ContainerState(status=exited, running=false, paused=false, restarting=false, oomKilled=false, dead=false, pid=0, exitCode=1, error=, startedAt=2023-12-12T06:39:44.866830904Z, finishedAt=2023-12-12T06:39:44.886715395Z, health=null), volumes=null, volumesRW=null, node=null, mounts=[InspectContainerResponse.Mount(name=5b1ac585e38032a0a4bbbd8b0ab389aa29c7d5cb05f093fdfffa6f7b09bf4940, source=/var/lib/docker/volumes/5b1ac585e38032a0a4bbbd8b0ab389aa29c7d5cb05f093fdfffa6f7b09bf4940/_data, destination=/var/lib/mysql, driver=local, mode=, rw=true)], graphDriver=GraphDriver(name=overlay2, data=GraphData(rootDir=null, deviceId=null, deviceName=null, deviceSize=null, dir=null)), platform=linux)> within 5 seconds.
        at org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:167)
        at org.testcontainers.shaded.org.awaitility.core.AbstractHamcrestCondition.await(AbstractHamcrestCondition.java:86)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:985)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:691)
        at org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:708)
        at org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:469)
        at org.testcontainers.containers.GenericContainer.lambda$doStart$0(GenericContainer.java:357)
        at org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:81)
        at org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:347)
        at org.testcontainers.containers.GenericContainer.start(GenericContainer.java:333)
        at org.testcontainers.jdbc.ContainerDatabaseDriver.connect(ContainerDatabaseDriver.java:134)
        at java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:681)
        at java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:190)
        at com.lingh.MySQLAndPostgresTest.openConnectionInMySQL(MySQLAndPostgresTest.java:35)
        at com.lingh.MySQLAndPostgresTest.lambda$testMySQL$1(MySQLAndPostgresTest.java:22)
        at org.awaitility.core.CallableCondition$ConditionEvaluationWrapper.eval(CallableCondition.java:99)
        at org.awaitility.core.ConditionAwaiter$ConditionPoller.call(ConditionAwaiter.java:248)
        at org.awaitility.core.ConditionAwaiter$ConditionPoller.call(ConditionAwaiter.java:235)
        at java.base@17.0.9/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        at java.base@17.0.9/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base@17.0.9/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base@17.0.9/java.lang.Thread.run(Thread.java:840)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:807)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:210)
Caused by: org.testcontainers.shaded.org.awaitility.core.DeadlockException: Deadlocked threads detected:


        at org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:159)
        ... 23 more
[awaitility-thread] ERROR tc.mysql:8.2.0-oracle - Log output from the failed container:
2023-12-12 06:39:44+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.2.0-1.el8 started.
2023-12-12 06:39:44+00:00 [ERROR] [Entrypoint]: mysqld failed while attempting to check config
        command was: mysqld --verbose --help --log-bin-index=/tmp/tmp.xpYWAU0U5P
        mysqld: Can't read dir of '/etc/mysql/conf.d/' (OS errno 20 - Not a directory)
mysqld: [ERROR] Stopped processing the 'includedir' directive in file /etc/my.cnf at line 36.
mysqld: [ERROR] Fatal error in defaults handling. Program aborted!

Starting Postgres ...
[awaitility-thread] INFO tc.postgres:16.1-bookworm - Creating container for image: postgres:16.1-bookworm
[awaitility-thread] INFO tc.postgres:16.1-bookworm - Container postgres:16.1-bookworm is starting: 635650f0eb09cde9ebdb05eb5d2792866d95599496ce715f04b7243330e9695c
[awaitility-thread] INFO tc.postgres:16.1-bookworm - Container postgres:16.1-bookworm started in PT1.762725S
[awaitility-thread] INFO tc.postgres:16.1-bookworm - Container is started (JDBC URL: jdbc:postgresql://localhost:59721/demo_ds_0?loggerLevel=OFF)
Postgres started
com.lingh.MySQLAndPostgresTest > testMySQL() FAILED

com.lingh.MySQLAndPostgresTest > testPostgres() SUCCESSFUL


Failures (1):
  JUnit Jupiter:MySQLAndPostgresTest:testMySQL()
    MethodSource [className = 'com.lingh.MySQLAndPostgresTest', methodName = 'testMySQL', methodParameterTypes = '']
    => org.testcontainers.containers.ContainerLaunchException: Container startup failed for image mysql:8.2.0-oracle
       org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:362)
       org.testcontainers.containers.GenericContainer.start(GenericContainer.java:333)
       org.testcontainers.jdbc.ContainerDatabaseDriver.connect(ContainerDatabaseDriver.java:134)
       java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:681)
       java.sql@17.0.9/java.sql.DriverManager.getConnection(DriverManager.java:190)
       [...]
     Caused by: org.rnorth.ducttape.RetryCountExceededException: Retry limit hit with exception
       org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:88)
       org.testcontainers.containers.GenericContainer.doStart(GenericContainer.java:347)
       [...]
     Caused by: org.testcontainers.containers.ContainerLaunchException: Could not create/start container
       org.testcontainers.containers.GenericContainer.tryStart(GenericContainer.java:566)
       org.testcontainers.containers.GenericContainer.lambda$doStart$0(GenericContainer.java:357)
       org.rnorth.ducttape.unreliables.Unreliables.retryUntilSuccess(Unreliables.java:81)
       [...]
     Caused by: org.testcontainers.shaded.org.awaitility.core.ConditionTimeoutException: org.testcontainers.containers.GenericContainer expected the predicate to return <true> but it returned <false> for input of <InspectContainerResponse(args=[mysqld], config=ContainerConfig(attachStderr=false, attachStdin=false, attachStdout=false, cmd=[mysqld], domainName=, entrypoint=[docker-entrypoint.sh], env=[MYSQL_DATABASE=demo_ds_0, MYSQL_ALLOW_EMPTY_PASSWORD=yes, PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin, GOSU_VERSION=1.16, MYSQL_MAJOR=innovation, MYSQL_VERSION=8.2.0-1.el8, MYSQL_SHELL_VERSION=8.0.35-1.el8], exposedPorts=[3306/tcp, 33060/tcp], hostName=505197496ada, image=mysql:8.2.0-oracle, labels={desktop.docker.io/wsl-distro=Ubuntu-22.04, org.testcontainers=true, org.testcontainers.lang=java, org.testcontainers.sessionId=c93531a3-df52-4c46-a0cb-341b10f4704a, org.testcontainers.version=1.19.3}, macAddress=null, networkDisabled=null, onBuild=null, stdinOpen=false, portSpecs=null, stdInOnce=false, tty=false, user=, volumes={/var/lib/mysql={}}, workingDir=, healthCheck=null), created=2023-12-12T06:39:44.476948482Z, driver=overlay2, execDriver=null, hostConfig=HostConfig(binds=[], blkioWeight=0, blkioWeightDevice=null, blkioDeviceReadBps=null, blkioDeviceWriteBps=null, blkioDeviceReadIOps=null, blkioDeviceWriteIOps=null, memorySwappiness=null, nanoCPUs=0, capAdd=null, capDrop=null, containerIDFile=, cpuPeriod=0, cpuRealtimePeriod=0, cpuRealtimeRuntime=0, cpuShares=0, cpuQuota=0, cpusetCpus=, cpusetMems=, devices=null, deviceCgroupRules=null, deviceRequests=null, diskQuota=null, dns=null, dnsOptions=null, dnsSearch=null, extraHosts=[], groupAdd=null, ipcMode=shareable, cgroup=, links=[], logConfig=LogConfig(type=json-file, config={}), lxcConf=null, memory=0, memorySwap=0, memoryReservation=0, kernelMemory=null, networkMode=default, oomKillDisable=false, init=null, autoRemove=false, oomScoreAdj=0, portBindings={3306/tcp=[Lcom.github.dockerjava.api.model.Ports$Binding;@450fdbcf}, privileged=false, publishAllPorts=false, readonlyRootfs=false, restartPolicy=no, ulimits=null, cpuCount=0, cpuPercent=0, ioMaximumIOps=0, ioMaximumBandwidth=0, volumesFrom=[], mounts=null, pidMode=, isolation=null, securityOpts=null, storageOpt=null, cgroupParent=, volumeDriver=, shmSize=67108864, pidsLimit=null, runtime=runc, tmpFs=null, utSMode=, usernsMode=, sysctls=null, consoleSize=[0, 0], cgroupnsMode=host), hostnamePath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/hostname, hostsPath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/hosts, logPath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864-json.log, id=505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864, sizeRootFs=null, sizeRw=null, imageId=sha256:f7fdab215ab77d3c9f93d4a1afa4b77850bc1b1ed1372ffe31b96ad9cd78a07e, mountLabel=, name=/charming_neumann, restartCount=0, networkSettings=NetworkSettings(bridge=, sandboxId=f0e7e05097f04cf15f028cda637dea942ec232f5142c3b8aa67a1399dc6697af, hairpinMode=false, linkLocalIPv6Address=, linkLocalIPv6PrefixLen=0, ports={}, sandboxKey=/var/run/docker/netns/f0e7e05097f0, secondaryIPAddresses=null, secondaryIPv6Addresses=null, endpointID=, gateway=, portMapping=null, globalIPv6Address=, globalIPv6PrefixLen=0, ipAddress=, ipPrefixLen=0, ipV6Gateway=, macAddress=, networks={bridge=ContainerNetwork(ipamConfig=null, links=[], aliases=null, networkID=16a6f18c4fec0552a4a69227ea0174e7b1b613d2507f47aaa9cadce7a13ed643, endpointId=, gateway=, ipAddress=, ipPrefixLen=0, ipV6Gateway=, globalIPv6Address=, globalIPv6PrefixLen=0, macAddress=)}), path=docker-entrypoint.sh, processLabel=, resolvConfPath=/var/lib/docker/containers/505197496ada7191e70c4a8d6d5c0b26393b33fc7bfb80b064979c7d0d80f864/resolv.conf, execIds=null, state=InspectContainerResponse.ContainerState(status=exited, running=false, paused=false, restarting=false, oomKilled=false, dead=false, pid=0, exitCode=1, error=, startedAt=2023-12-12T06:39:44.866830904Z, finishedAt=2023-12-12T06:39:44.886715395Z, health=null), volumes=null, volumesRW=null, node=null, mounts=[InspectContainerResponse.Mount(name=5b1ac585e38032a0a4bbbd8b0ab389aa29c7d5cb05f093fdfffa6f7b09bf4940, source=/var/lib/docker/volumes/5b1ac585e38032a0a4bbbd8b0ab389aa29c7d5cb05f093fdfffa6f7b09bf4940/_data, destination=/var/lib/mysql, driver=local, mode=, rw=true)], graphDriver=GraphDriver(name=overlay2, data=GraphData(rootDir=null, deviceId=null, deviceName=null, deviceSize=null, dir=null)), platform=linux)> within 5 seconds.
       org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:167)
       org.testcontainers.shaded.org.awaitility.core.AbstractHamcrestCondition.await(AbstractHamcrestCondition.java:86)
       org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:985)
       org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:691)
       org.testcontainers.shaded.org.awaitility.core.ConditionFactory.until(ConditionFactory.java:708)
       [...]
     Caused by: org.testcontainers.shaded.org.awaitility.core.DeadlockException: Deadlocked threads detected:


       org.testcontainers.shaded.org.awaitility.core.ConditionAwaiter.await(ConditionAwaiter.java:159)
       [...]

Test run finished after 19208 ms
[         2 containers found      ]
[         0 containers skipped    ]
[         2 containers started    ]
[         0 containers aborted    ]
[         2 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         1 tests successful      ]
[         1 tests failed          ]


> Task :nativeTest FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':nativeTest'.
> Process 'command '/home/linghengqian/TwinklingLiftWorks/git/public/testcontainers-java-mysql-graalvm-native-test/build/native/nativeTestCompile/testcontainers-java-mysql-graalvm-native-test-tests'' finished with non-zero exit value 1

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 3m 35s
8 actionable tasks: 8 executed


```