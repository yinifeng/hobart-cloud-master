package com.hobart.test.myrule;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡算法
 * 
 * 需求：
 * 		每个服务访问5次，再轮询到下一个服务
 * 
 * @author hobart
 *
 */
public class RandomRule_HB extends AbstractLoadBalancerRule {
	
	private AtomicInteger total=new AtomicInteger(0);
	private AtomicInteger currentIndex=new AtomicInteger(0);
    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);
            if(total.get()<5){
            	server=upList.get(currentIndex.get());
            	//先获取在自增
            	
            	//先自增再获取
            	total.incrementAndGet();
            }else{
            	total.set(0);//初始化0
            	if(currentIndex.incrementAndGet() >= upList.size()){
            		currentIndex.set(0);
            	}
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }
    
    /**
     * 随机负载均衡算法
     * @param serverCount
     * @return
     */
    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}
