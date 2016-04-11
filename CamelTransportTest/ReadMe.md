Camel-transport for CXF test
=========================================

Test project for Camel Transport for CXF.

The project contains one test case. Also can be run using the camel-maven-plugin or deploying to a Fuse instance, the bundle contains a timer to call the route once when started.
* Run test: mvn clean test
* Use camel-maven-plugin: mvn clean package camel:run -DskipTests
* Build: mvn clean install -DskipTests
* Deploy in Fuse: JBossFuse:karaf@root> install -s mvn:com.mycompany/CamelTransportTest/1.0.0-SNAPSHOT

Run was succesfully tested with Fuse 6.1.0.

Issues were found using Fuse 6.2.1. Use maven profile "Fuse621" to test:
* Run test: mvn -P Fuse621 clean test
* Use camel-maven-plugin: mvn -P Fuse621 clean package camel:run -DskipTests
* Build: mvn -P Fuse621 clean install -DskipTests
* Deploy in Fuse: JBossFuse:karaf@root> install -s mvn:com.mycompany/CamelTransportTest/1.0.0-SNAPSHOT

### Exception with Fuse 6.2.1
2016-04-11 15:34:49,818 | ERROR | l Console Thread | BlueprintCamelContext            | 204 - org.apache.camel.camel-blueprint - 2.15.1.redhat-621090 | Error occurred during starting Camel: CamelContext(myCamelContext) due CamelContext must be specified on: org.apache.camel.component.cxf.transport.CamelDestination@289b1d6
java.lang.IllegalArgumentException: CamelContext must be specified on: org.apache.camel.component.cxf.transport.CamelDestination@289b1d6
	at org.apache.camel.util.ObjectHelper.notNull(ObjectHelper.java:312)
	at org.apache.camel.component.cxf.transport.CamelDestination.activate(CamelDestination.java:110)
	at org.apache.cxf.transport.AbstractObservable.setMessageObserver(AbstractObservable.java:53)
	at org.apache.cxf.binding.AbstractBindingFactory.addListener(AbstractBindingFactory.java:95)
	at org.apache.cxf.jaxrs.JAXRSBindingFactory.addListener(JAXRSBindingFactory.java:88)
	at org.apache.cxf.endpoint.ServerImpl.start(ServerImpl.java:123)
	at org.apache.camel.component.cxf.jaxrs.CxfRsConsumer.doStart(CxfRsConsumer.java:50)
	at org.apache.camel.support.ServiceSupport.start(ServiceSupport.java:61)
	at org.apache.camel.impl.DefaultCamelContext.startService(DefaultCamelContext.java:2869)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.doStartOrResumeRouteConsumers(DefaultCamelContext.java:3163)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.doStartRouteConsumers(DefaultCamelContext.java:3099)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.safelyStartRouteServices(DefaultCamelContext.java:3029)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.doStartOrResumeRoutes(DefaultCamelContext.java:2797)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.doStartCamel(DefaultCamelContext.java:2653)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.access$000(DefaultCamelContext.java:167)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext$2.call(DefaultCamelContext.java:2467)
	at org.apache.camel.impl.DefaultCamelContext$2.call(DefaultCamelContext.java:2463)
	at org.apache.camel.impl.DefaultCamelContext.doWithDefinedClassLoader(DefaultCamelContext.java:2486)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.impl.DefaultCamelContext.doStart(DefaultCamelContext.java:2463)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.support.ServiceSupport.start(ServiceSupport.java:61)
	at org.apache.camel.impl.DefaultCamelContext.start(DefaultCamelContext.java:2432)[198:org.apache.camel.camel-core:2.15.1.redhat-621090]
	at org.apache.camel.blueprint.BlueprintCamelContext.start(BlueprintCamelContext.java:180)
	at org.apache.camel.blueprint.BlueprintCamelContext.maybeStart(BlueprintCamelContext.java:212)
	at org.apache.camel.blueprint.BlueprintCamelContext.serviceChanged(BlueprintCamelContext.java:150)
	at org.apache.felix.framework.util.EventDispatcher.invokeServiceListenerCallback(EventDispatcher.java:943)
	at org.apache.felix.framework.util.EventDispatcher.fireEventImmediately(EventDispatcher.java:794)
	at org.apache.felix.framework.util.EventDispatcher.fireServiceEvent(EventDispatcher.java:544)
	at org.apache.felix.framework.Felix.fireServiceEvent(Felix.java:4445)
	at org.apache.felix.framework.Felix.registerService(Felix.java:3431)
	at org.apache.felix.framework.BundleContextImpl.registerService(BundleContextImpl.java:346)
	at org.apache.aries.blueprint.container.BlueprintContainerImpl.registerService(BlueprintContainerImpl.java:453)
	at org.apache.aries.blueprint.container.BlueprintContainerImpl.doRun(BlueprintContainerImpl.java:388)
	at org.apache.aries.blueprint.container.BlueprintContainerImpl.run(BlueprintContainerImpl.java:269)
	at org.apache.aries.blueprint.container.BlueprintExtender.createContainer(BlueprintExtender.java:294)
	at org.apache.aries.blueprint.container.BlueprintExtender.createContainer(BlueprintExtender.java:263)
	at org.apache.aries.blueprint.container.BlueprintExtender.modifiedBundle(BlueprintExtender.java:253)
	at org.apache.aries.util.tracker.hook.BundleHookBundleTracker$Tracked.customizerModified(BundleHookBundleTracker.java:500)
	at org.apache.aries.util.tracker.hook.BundleHookBundleTracker$Tracked.customizerModified(BundleHookBundleTracker.java:433)
	at org.apache.aries.util.tracker.hook.BundleHookBundleTracker$AbstractTracked.track(BundleHookBundleTracker.java:725)
	at org.apache.aries.util.tracker.hook.BundleHookBundleTracker$Tracked.bundleChanged(BundleHookBundleTracker.java:463)
	at org.apache.aries.util.tracker.hook.BundleHookBundleTracker$BundleEventHook.event(BundleHookBundleTracker.java:422)
	at org.apache.felix.framework.util.SecureAction.invokeBundleEventHook(SecureAction.java:1127)
	at org.apache.felix.framework.util.EventDispatcher.createWhitelistFromHooks(EventDispatcher.java:696)
	at org.apache.felix.framework.util.EventDispatcher.fireBundleEvent(EventDispatcher.java:484)
	at org.apache.felix.framework.Felix.fireBundleEvent(Felix.java:4429)
	at org.apache.felix.framework.Felix.startBundle(Felix.java:2100)
	at org.apache.felix.framework.BundleImpl.start(BundleImpl.java:976)
	at org.apache.felix.framework.BundleImpl.start(BundleImpl.java:963)
	at org.apache.karaf.shell.osgi.StartBundle.doExecute(StartBundle.java:37)
	at org.apache.karaf.shell.osgi.BundlesCommand.doExecute(BundlesCommand.java:37)
	at org.apache.karaf.shell.console.OsgiCommandSupport.execute(OsgiCommandSupport.java:38)
	at org.apache.felix.gogo.commands.basic.AbstractCommand.execute(AbstractCommand.java:35)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)[:1.7.0_80]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)[:1.7.0_80]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)[:1.7.0_80]
	at java.lang.reflect.Method.invoke(Method.java:606)[:1.7.0_80]
	at org.apache.aries.proxy.impl.ProxyHandler$1.invoke(ProxyHandler.java:54)[19:org.apache.aries.proxy.impl:1.0.4]
	at org.apache.aries.proxy.impl.ProxyHandler.invoke(ProxyHandler.java:119)[19:org.apache.aries.proxy.impl:1.0.4]
	at org.apache.karaf.shell.console.commands.$BlueprintCommand516227519.execute(Unknown Source)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.CommandProxy.execute(CommandProxy.java:78)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.Closure.executeCmd(Closure.java:477)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.Closure.executeStatement(Closure.java:403)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.Pipe.run(Pipe.java:108)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.Closure.execute(Closure.java:183)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.Closure.execute(Closure.java:120)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.felix.gogo.runtime.CommandSessionImpl.execute(CommandSessionImpl.java:92)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.karaf.shell.console.jline.Console.run(Console.java:197)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
	at org.apache.karaf.shell.console.jline.DelayedStarted.run(DelayedStarted.java:79)[38:org.apache.karaf.shell.console:2.4.0.redhat-621090]
