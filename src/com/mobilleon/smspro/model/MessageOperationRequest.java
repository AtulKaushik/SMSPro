/**
 *  message import / export
 *  request model object
 * */

package com.mobilleon.smspro.model;

import android.content.SharedPreferences;

import com.mobilleon.smspro.utilities.IncomingMailServerConnection;
import com.mobilleon.smspro.utilities.OutgoingMailServerConnection;

/**
 * @author Atul Kaushik (kaushik.atul@gmail.com)
 *
 */
public class MessageOperationRequest {

    public Integer mImportRange;  // range for messages to be imported from server
    public Integer mImportRangeMultiplier = 1; // range multiplier for next set of messages to be imported from server, 1 being default value
    public SharedPreferences mPreferences;
    public OutgoingMailServerConnection mOutgoingMailServerConnection;
    public IncomingMailServerConnection mIncomingMailServerConnection;
}
