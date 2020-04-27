/*
package com.gridu.BEProgram;

import com.gridu.BEProgram.DAOs.DogDAO;
import com.gridu.BEProgram.controllers.rest.DogController;
import com.gridu.BEProgram.services.DogServiceImpl;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletResponse;
import java.net.URISyntaxException;

public class ComponentRESTTest {

    @Test
    public void test1() {

        POJOResourceFactory factory = new POJOResourceFactory(DogController.class);


        Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getRegistry().addResourceFactory(factory);

        MockHttpRequest request = null;
        try {
            request = MockHttpRequest.get("/api/v1/dogs");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        MockHttpResponse response = new MockHttpResponse();


        dispatcher.invoke(request, response);
    }



















//    private static Dispatcher dispatcher;
//    private static DogController dogController;
//    private static DogServiceImpl dogService;
//    private DogDAO dataBase;
//
//    // This code here gets run before our tests begin
//    @BeforeClass
//    public void setup() {
//        dispatcher = MockDispatcherFactory.createDispatcher();
//        dataBase = mock(InMemoryImpl.class);
//
//        dogService = new DogServiceImpl();
//        dogService.setDogDAO(dataBase);
//
//        dogController = new DogController();
//        dogController.setDogService(dogService);
//
////        Dog dog = new Dog();
////        dog.setName("TV");
////        dog.setQty(50);
////        when(dataBase.getById("TV")).thenReturn(dog);
//
//        dispatcher.getRegistry().addSingletonResource(dogService);
//    }
//
//    @Test
//    public void helloTest() throws Exception {
//        MockHttpResponse response = sendAsyncPostRequest("/product", createRequestJSON("TV"));
//        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
//        Assert.assertEquals(createResponseJSON("TV", 50), getPrettyPrintJSON(response.getContentAsString()));
//    }
//
//    public MockHttpResponse sendAsyncPostRequest(
//            String path,
//            String requestBody) throws URISyntaxException, JAXBException {
//
//        MockHttpRequest request = MockHttpRequest.post(path);
//        request.accept(MediaType.APPLICATION_JSON);
//        request.contentType(MediaType.APPLICATION_JSON_TYPE);
//        request.content(requestBody.getBytes());
//
//        MockHttpResponse response = new MockHttpResponse();
//        SynchronousExecutionContext synchronousExecutionContext = new SynchronousExecutionContext((SynchronousDispatcher) dispatcher, request, response);
//        request.setAsynchronousContext(synchronousExecutionContext);
//        return sendHttpRequest(request, response);
//    }
//
//    private MockHttpResponse sendHttpRequest(MockHttpRequest request, MockHttpResponse response) throws URISyntaxException {
//        dispatcher.invoke(request, response);
//        return response;
//    }
}
*/
