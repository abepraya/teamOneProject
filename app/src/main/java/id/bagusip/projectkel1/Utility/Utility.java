package id.bagusip.projectkel1.Utility;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class Utility {
    public String getMacAddressMobile() {
        try{
            List<NetworkInterface> networkInterfaceList = Collections.list(NetworkInterface.getNetworkInterfaces());
            String macAddress = "";
            for(NetworkInterface networkInterface : networkInterfaceList)
            {
                if(networkInterface.getName().equalsIgnoreCase("wlon0"));
                {
                    for(int i = 0 ;i <networkInterface.getHardwareAddress().length; i++){
                        String stringMacByte = Integer.toHexString(networkInterface.getHardwareAddress()[i]& 0xFF);
                        if(stringMacByte.length() == 1)
                        {
                            stringMacByte = "0" +stringMacByte;
                        }
                        macAddress = macAddress + stringMacByte.toUpperCase() + ":";
                    }
                    break;
                }
            }
            return macAddress;
        }catch (SocketException e)
        {
            e.printStackTrace();
        }
        return  "0";
    }

}
