package ca.jrvs.apps.grep;

public class RegexExcImp implements RegexExc{

    @Override
    public boolean matchJpeg(String filename) {
        String pattern = ".*\\.(?i)(jpg|jpeg)$";
        return filename.matches(pattern);
    }

    @Override
    public boolean matchIp(String ip) {
        String startIP = "0.0.0.0";
        String endIP = "999.999.999.999";

        String[] ipParts = ip.split("\\.");
        String[] startIPParts = startIP.split("\\.");
        String[] endIPParts = endIP.split("\\.");

        for (int i = 0; i < 4; i++) {
            int ipPart = Integer.parseInt(ipParts[i]);
            int startIPPart = Integer.parseInt(startIPParts[i]);
            int endIPPart = Integer.parseInt(endIPParts[i]);
            if (ipPart < startIPPart || ipPart > endIPPart) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmptyLine(String line) {
        return line.matches("^\\s*$");
    }
}
