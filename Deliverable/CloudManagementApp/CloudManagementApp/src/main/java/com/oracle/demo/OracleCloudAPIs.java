package com.oracle.demo;

import org.apache.commons.codec.binary.Base64;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class OracleCloudAPIs {

    public String viewAllServiceInstances(String userName, String pwd, String iDomain) {
        String result = "";
        String msg = "";
        try {
            Client client = Client.create();
            client.addFilter(new LoggingFilter(System.out));
            String username = userName;
            String password = pwd;
            String authString = username + ":" + password;
            String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));

            WebResource wr =
                Client.create(new DefaultClientConfig()).resource("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/" +
                                                                  iDomain);
            String authKey = "Basic " + authStringEnc;

            ClientResponse r =
                wr.header("Content-Type", "application/json;charset=UTF-8").header("Authorization",
                                                                                   authKey).header("X-ID-TENANT-NAME",
                                                                                                   iDomain).get(ClientResponse.class);
            result = r.getEntity(String.class);
        } catch (Exception e) {
            result = "{'error':e.getMessage()}";
        }
        return result;
    }

    public String viewServiceInstance(String userName, String pwd, String iDomain, String serviceID) {
        String result = "";
        String msg = "";
        try {
            Client client = Client.create();
            client.addFilter(new LoggingFilter(System.out));
            String username = userName;
            String password = pwd;
            String authString = username + ":" + password;
            String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));

            WebResource wr =
                Client.create(new DefaultClientConfig()).resource("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/" +
                                                                  iDomain + "/" + serviceID);
            String authKey = "Basic " + authStringEnc;

            ClientResponse r =
                wr.header("Content-Type", "application/json;charset=UTF-8").header("Authorization",
                                                                                   authKey).header("X-ID-TENANT-NAME",
                                                                                                   iDomain).get(ClientResponse.class);

            System.out.println(r);
            result = r.getEntity(String.class);
        } catch (Exception e) {
            result = "{'error':e.getMessage()}";
        }
        return result;
    }

    public String deleteCoherenceDataTierCluster(String userName, String pwd, String iDomain, String serviceID,
                                               String clusterName) {
        String result = "";
        try {
            Client client = Client.create();
            client.addFilter(new LoggingFilter(System.out));
            String username = userName;
            String password = pwd;
            String authString = username + ":" + password;
            String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
            System.out.println("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/" +
                                                                  iDomain + "/" + serviceID + "/clusters/" + clusterName);
            WebResource wr =
                Client.create(new DefaultClientConfig()).resource("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/" +
                                                                  iDomain + "/" + serviceID + "/clusters/" + clusterName);
            String authKey = "Basic " + authStringEnc;
            
            ClientResponse r =
                wr.header("Content-Type", "application/json;charset=UTF-8").header("Authorization",
                                                                                   authKey).header("X-ID-TENANT-NAME",
                                                                                                   iDomain).delete(ClientResponse.class);
            result = r.getHeaders().toString();
            result = r + "\n" + result;
            System.out.println("Headers: " + result);
        }catch(Exception e) {
            result = "{'error':e.getMessage()}";
        }
        return result;
    }


    public String viewStatus(String userName, String pwd, String iDomain, String responseURL)  {
        String result = "";
        try {
            Client client = Client.create();
            client.addFilter(new LoggingFilter(System.out));
            String username = userName;
            String password = pwd;
            String authString = username + ":" + password;
            String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
            System.out.println("responseURL: " + responseURL);
            WebResource wr = Client.create(new DefaultClientConfig()).resource(responseURL);
            String authKey = "Basic " + authStringEnc;

            ClientResponse r =
                wr.header("Content-Type", "application/json;charset=UTF-8").header("Authorization",
                                                                                   authKey).header("X-ID-TENANT-NAME",
                                                                                                   iDomain).get(ClientResponse.class);
            result = r.getEntity(String.class);
            //result = r + "\n" + result;
            System.out.println("Headers: " + result);
        }catch (Exception e) {
            result = "{'error':e.getMessage()}";
        }
        return result;
    }

    
    public String deleteServiceInstance(String userName, String pwd, String iDomain, String serviceID, String dbName, String dbPassword) {
                System.out.println("*******");
                String result = "";
                String msg = "";
                try {
                    Client client = Client.create();
                    client.addFilter(new LoggingFilter(System.out));
                    String username = userName;
                    String password = pwd;
                    String authString = username + ":" + password;
                    String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
                    
                    WebResource wr = Client.create(new DefaultClientConfig()).resource("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/"+iDomain+"/"+serviceID);
                    String authKey = "Basic " + authStringEnc;
                    
                    StringBuilder in = new StringBuilder();
                    in.append("{");
                    in.append("\"dbaName\"").append(":").append("\"").append(dbName).append("\"");
                    in.append(",");
                    in.append("\"dbaPassword\"").append(":").append("\"").append(dbPassword).append("\"");
                    in.append("}");
                    System.out.println(in);


                    ClientResponse r =
                        wr.header("Authorization", authKey).header("Content-Type",
                                                                   "application/vnd.com.oracle.oracloud.provisioning.Service+json").header("X-ID-TENANT-NAME",
                                                                                                                                       iDomain).type("application/vnd.com.oracle.oracloud.provisioning.Service+json").put(ClientResponse.class,in.toString());
                 
                    
                    System.out.println(r);
                    
                    

                    result = r.getHeaders().toString(); 
                    System.out.println(result);
                    result = r + "\n" + result;
                    
                }catch (Exception e) {
                    result = "{'error':e.getMessage()}";
                }
                   
            return result;
            }

    public String addCoherenceDataTierCluster(String userName, String pwd, String iDomain,
                                            String serviceID, String clusterType, String scalingUnitCount, String clusterName, String scalingUnitName) {
     
        String result = "";
        try {
            Client client = Client.create();
            client.addFilter(new LoggingFilter(System.out));
            String username = userName;
            String password = pwd;
            String authString = username + ":" + password;
            String authStringEnc = new String(Base64.encodeBase64(authString.getBytes()));
            System.out.println("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/" +
                                                                  iDomain + "/" + serviceID + "/clusters");
            WebResource wr =
                Client.create(new DefaultClientConfig()).resource("https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/" +
                                                                  iDomain + "/" + serviceID + "/clusters");
            String authKey = "Basic " + authStringEnc;
            
            clusterType = "DG";
            scalingUnitCount = "1";
            scalingUnitName = "BASIC";
                

            StringBuilder in = new StringBuilder();
            in.append("{");
            in.append("\"clusterType\"").append(":").append("\"" + clusterType +"\"");
            in.append(",");
            in.append("\"scalingUnitCount\"").append(":").append("\""+ scalingUnitCount + "\"");
            in.append(",");
            in.append("\"scalingUnitName\"").append(":").append("\"" + scalingUnitName + "\"");
            in.append("}");
            System.out.println(in);
            
            
            ClientResponse r =
                wr.header("Authorization", authKey).header("Content-Type",
                                                           "application/vnd.com.oracle.oracloud.datagrid.Service+json").header("X-ID-TENANT-NAME",
                                                                                                                               iDomain).type("application/vnd.com.oracle.oracloud.datagrid.Service+json").post(ClientResponse.class,
                                                                                                                                                                                                               in.toString());
            result = r.getHeaders().toString();
            result = r + "\n" + result;
            
            System.out.println("Headers: " + result);
        } catch(Exception e) {
            result = "{'error':e.getMessage()}";
        }
                
 
        return result;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Start of Processing");
        //new OracleCloudAPIs().viewAllServiceInstances("shashank.tilwalli@oracle.com", "Ananya21!", "inoracle06606");
        //new OracleCloudAPIs().viewServiceInstance("shashank.tilwalli@oracle.com", "Ananya21!", "inoracle06606", "myJCS");
        //new OracleCloudAPIs().deleteCoherenceDataTierCluster("shashank.tilwalli@oracle.com", "Ananya21!", "inoracle06606", "myJCS", "myJCS_DGCluster");
        //new OracleCloudAPIs().addCoherenceDataTierCluster("shashank.tilwalli@oracle.com", "Ananya21!", "inoracle06606", "myJCS", "", "", "", "");
        new OracleCloudAPIs().deleteServiceInstance("shashank.tilwalli@oracle.com", "Ananya21!", "inoracle06606", "myJCS", "sys", "Ananya21#");

        //new OracleCloudAPIs().viewStatus("shashank.tilwalli@oracle.com", "Ananya21!", "inoracle06606", "https://jaas.oraclecloud.com/paas/service/jcs/api/v1.1/instances/inoracle06606/status/scale/job/212205");
        //main1(args);

    }

}
