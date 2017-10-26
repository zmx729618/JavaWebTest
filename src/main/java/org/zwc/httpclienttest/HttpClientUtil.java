package org.zwc.httpclienttest;

import org.apache.http.HttpResponse;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;


/**
 * Created by zhangwenchao on 2017/10/26.
 */
public class HttpClientUtil {
    private static final Integer MAX_TOTAL = 100;
    private static final Integer MAX_PERROUTE = 10;

    public static CloseableHttpClient getHttpClient() {
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = new ServiceUnavailableRetryStrategy() {
            /**
             * retry逻辑
             */
            public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context) {

                if (executionCount <= 3) {
                    System.out.println(executionCount);
                    return true;
                }else
                    return false;
                }

            /**
             * retry间隔时间
             */
            public long getRetryInterval() {
                return 3000;
            }
        };
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(MAX_TOTAL);
        cm.setDefaultMaxPerRoute(MAX_PERROUTE);
        CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(new DefaultHttpRequestRetryHandler())
                .setConnectionManager(cm).build();
        return httpClient;
    }


    @Test
    public void test1(){
        HttpPost httpPost=new HttpPost("http://www.baidu11.com");
        try {
            CloseableHttpClient  httpClient = getHttpClient();
            CloseableHttpResponse rsp=httpClient.execute(httpPost);
            System.out.println(">> {}"+rsp.getStatusLine().getStatusCode());
        } catch (Exception e) {
            System.err.println(e);
        }finally{

        }
    }

}
