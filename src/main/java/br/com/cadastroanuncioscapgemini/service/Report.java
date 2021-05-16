package br.com.cadastroanuncioscapgemini.service;

import br.com.cadastroanuncioscapgemini.model.Ad;
import java.time.temporal.ChronoUnit;

public class Report {
    private  Long adId;

    private String adClient;

    private Double totalInvestment;

    private Double maxViews;

    private Double maxClicks;

    private Double maxShares;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public String getAdClient() {
        return adClient;
    }

    public void setAdClient(String adClient) {
        this.adClient = adClient;
    }

    public Double getMaxViews() {
        return maxViews;
    }

    public void setMaxViews(Double maxViews) {
        this.maxViews = maxViews;
    }

    public Double getMaxClicks() {
        return maxClicks;
    }

    public void setMaxClicks(Double maxClicks) {
        this.maxClicks = maxClicks;
    }

    public Double getMaxShares() {
        return maxShares;
    }

    public void setMaxShares(Double maxShares) {
        this.maxShares = maxShares;
    }

    public Report(Ad ad) {
        this.adId = ad.getId();
        this.adClient = ad.getClient();
        this.totalInvestment = this.calculateTotalInvestment(ad);
        this.maxViews = this.calculateViews(ad);
        this.maxClicks = this.calculateClicks(ad);
        this.maxShares = this.calculateShares(ad);
    }

    private Double calculateTotalInvestment(Ad ad) {
        return ChronoUnit.DAYS.between(ad.getStartDate(), ad.getEndDate()) * ad.getDailyInvestment();
    }

    private Double calculateViews(Ad ad) {
        Double totalInvest = calculateTotalInvestment(ad);
        return calculateTotalViewsByTotalInvestment(totalInvest);
    }

    public static  final double clicksPercentual = 0.12;
    public static  final int viewsPerReal = 30;
    public static  final double sharesPercentual = 0.15;
    public static  final int viewsPerShare = 40;

    private Double calculateClicks(Ad ad) {
        Double totalInvest = calculateTotalInvestment(ad);

        double viewsOriginalAd = totalInvest * viewsPerReal;
        double clicksOriginalAd = viewsOriginalAd * clicksPercentual;

        double viewsFirstShare = calculateViewsPerShare(viewsOriginalAd);
        double clicksFirstShare = viewsFirstShare * clicksPercentual;

        double viewsSecondShare = calculateViewsPerShare(viewsFirstShare);
        double clicksSecondShare = viewsSecondShare * clicksPercentual;

        double viewsThirdShare = calculateViewsPerShare(viewsSecondShare);
        double clicksThirdShare = viewsThirdShare * clicksPercentual;

        return clicksOriginalAd + clicksFirstShare + clicksSecondShare + clicksThirdShare;
    }

    private Double calculateShares(Ad ad) {
        Double totalInvest = calculateTotalInvestment(ad);

        double viewsOriginalAd = totalInvest * viewsPerReal;
        double clicksOriginalAd = viewsOriginalAd * clicksPercentual;
        double sharesOriginalAd = clicksOriginalAd * sharesPercentual;

        double viewsFirstShare = calculateViewsPerShare(viewsOriginalAd);
        double clicksFirstShare = viewsFirstShare * clicksPercentual;
        double sharesFistCycle = clicksFirstShare * sharesPercentual;


        double viewsSecondShare = calculateViewsPerShare(viewsFirstShare);
        double clicksSecondShare = viewsSecondShare * clicksPercentual;
        double sharesSecondCycle = clicksSecondShare * sharesPercentual;

        double viewsThirdShare = calculateViewsPerShare(viewsSecondShare);
        double clicksThirdShare = viewsThirdShare * clicksPercentual;
        double sharesThirdCycle = clicksThirdShare * sharesPercentual;


        return sharesOriginalAd + sharesFistCycle + sharesSecondCycle + sharesThirdCycle;
    }

    public static double calculateViewsPerShare(double views) {
        double toatlClicks = views * clicksPercentual;
        double totalShares = toatlClicks * sharesPercentual;
        double totalViwesPrShare = totalShares * viewsPerShare;

        return  totalViwesPrShare;
    }

    public static double calculateTotalViewsByTotalInvestment(double invest ) {
        double viewsOriginalAd = invest * viewsPerReal;

        double viewsFirstShare = calculateViewsPerShare(viewsOriginalAd);
        double viewsSecondShare = calculateViewsPerShare(viewsFirstShare);
        double viewsThirdShare = calculateViewsPerShare(viewsSecondShare);
        double totalViews = viewsOriginalAd + viewsFirstShare + viewsSecondShare + viewsThirdShare;
        return totalViews;
    }
}
