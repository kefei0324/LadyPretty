package org.paul.ladypretty.bean;

import java.util.List;
import java.util.Map;

public class BroadBandLinePerformance {

    private String lineId, offeringId, subscriberName, lineAddress, lineCoordinate;
    private int bandWidth;
    private long effDate, expDate;
    private Map<String, Float> upLinkTraffics, downLinkTraffics, avgUpLinkSpeeds, avgDownLinkSpeeds, upLinkUtilizations, downLinkUtilizations;

    @Override
    public String toString() {
        return "BroadBandLinePerformance{" +
                "lineId='" + lineId + '\'' +
                ", offeringId='" + offeringId + '\'' +
                ", subscriberName='" + subscriberName + '\'' +
                ", lineAddress='" + lineAddress + '\'' +
                ", lineCoordinate='" + lineCoordinate + '\'' +
                ", bandWidth=" + bandWidth +
                ", effDate=" + effDate +
                ", expDate=" + expDate +
                ", upLinkTraffics=" + upLinkTraffics +
                ", downLinkTraffics=" + downLinkTraffics +
                ", avgUpLinkSpeeds=" + avgUpLinkSpeeds +
                ", avgDownLinkSpeeds=" + avgDownLinkSpeeds +
                ", upLinkUtilizations=" + upLinkUtilizations +
                ", downLinkUtilizations=" + downLinkUtilizations +
                '}';
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getOfferingId() {
        return offeringId;
    }

    public void setOfferingId(String offeringId) {
        this.offeringId = offeringId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getLineAddress() {
        return lineAddress;
    }

    public void setLineAddress(String lineAddress) {
        this.lineAddress = lineAddress;
    }

    public String getLineCoordinate() {
        return lineCoordinate;
    }

    public void setLineCoordinate(String lineCoordinate) {
        this.lineCoordinate = lineCoordinate;
    }

    public int getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(int bandWidth) {
        this.bandWidth = bandWidth;
    }

    public long getEffDate() {
        return effDate;
    }

    public void setEffDate(long effDate) {
        this.effDate = effDate;
    }

    public long getExpDate() {
        return expDate;
    }

    public void setExpDate(long expDate) {
        this.expDate = expDate;
    }

    public Map<String, Float> getUpLinkTraffics() {
        return upLinkTraffics;
    }

    public void setUpLinkTraffics(Map<String, Float> upLinkTraffics) {
        this.upLinkTraffics = upLinkTraffics;
    }

    public Map<String, Float> getDownLinkTraffics() {
        return downLinkTraffics;
    }

    public void setDownLinkTraffics(Map<String, Float> downLinkTraffics) {
        this.downLinkTraffics = downLinkTraffics;
    }

    public Map<String, Float> getAvgUpLinkSpeeds() {
        return avgUpLinkSpeeds;
    }

    public void setAvgUpLinkSpeeds(Map<String, Float> avgUpLinkSpeeds) {
        this.avgUpLinkSpeeds = avgUpLinkSpeeds;
    }

    public Map<String, Float> getAvgDownLinkSpeeds() {
        return avgDownLinkSpeeds;
    }

    public void setAvgDownLinkSpeeds(Map<String, Float> avgDownLinkSpeeds) {
        this.avgDownLinkSpeeds = avgDownLinkSpeeds;
    }

    public Map<String, Float> getUpLinkUtilizations() {
        return upLinkUtilizations;
    }

    public void setUpLinkUtilizations(Map<String, Float> upLinkUtilizations) {
        this.upLinkUtilizations = upLinkUtilizations;
    }

    public Map<String, Float> getDownLinkUtilizations() {
        return downLinkUtilizations;
    }

    public void setDownLinkUtilizations(Map<String, Float> downLinkUtilizations) {
        this.downLinkUtilizations = downLinkUtilizations;
    }
}
