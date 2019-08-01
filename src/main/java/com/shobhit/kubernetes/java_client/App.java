package com.shobhit.kubernetes.java_client;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Endpoints;
import io.kubernetes.client.models.V1EndpointsList;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException, ApiException {
		ApiClient client = Config.fromCluster();
		Configuration.setDefaultApiClient(client);

		CoreV1Api api = new CoreV1Api();
		
		V1EndpointsList nsList = api.listEndpointsForAllNamespaces(null, null, null, null, null, null, null, null,
				null);
		System.out.println("================Namespace list================");
		for (V1Endpoints item : nsList.getItems()) {
			System.out.println(item.getMetadata().getName());
		}

		V1PodList podList = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
		System.out.println("================Pod list================");
		for (V1Pod item : podList.getItems()) {
			System.out.println(item.getMetadata().getName());
		}
	}
}