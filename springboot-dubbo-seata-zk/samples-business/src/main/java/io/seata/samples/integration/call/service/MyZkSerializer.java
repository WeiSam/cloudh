package io.seata.samples.integration.call.service;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

import java.nio.charset.StandardCharsets;

public class MyZkSerializer implements ZkSerializer
{
	 	@Override
	    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
	        	return new String(bytes, StandardCharsets.UTF_8);
	    }
	 	
	    @Override
	    public byte[] serialize(Object serializable) throws ZkMarshallingError {
	        	return ((String)serializable).getBytes(StandardCharsets.UTF_8);
	    }
}