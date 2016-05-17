/**
 * A generic class to hold
 * response from API/Server calls
 * */
package com.mobilleon.smspro.model;

/**
 * @author Atul Kaushik (kaushik.atul@gmail.com)
 *
 */
public class SMSProData<Type> {

    public Type response;
    public int responseErrorCode;
    public boolean requestSuccessful;
}
