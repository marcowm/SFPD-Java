/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfpd.enums;

/**
 *
 * @author F5115716
 * @since Jun 1, 2017
 */
public enum TipoObjetoRisco {
    AMERICAN("American"),
    BONDMODEL("Bond Model"),
    BRADYBOND("Brady Bond"),
    BRAZILDIFUTURE("Brazil DI Future"),
    BRAZILCOUPONFUTURE("Brazil Coupon Future"),
    CASHINSTRUMENT("Cash Instrument"),
    COMMODITYFUTURE("Commodity Future"),
    COMMONSTOCK("Common Stock"),
    CONSTANTTERMBULLETBOND("Constant Term Bullet Bond"),
    CONSTANTTERMFOREXFORWARD("Constant Term Forex Forward"),
    CURRENCY("Currency"),
    CURVEINDEX("Curve Index"),
    CURVESURFACE("CurveSurface"),
    DYNAMICPORTFOLIO("DynamicPortfolio"),
    EQUITYFUTURE("Equity Future"),
    EUROPEAN("European"),
    EXCHANGERATECURVE("Exchange Rate Curve"),
    FXCONVERTER("FXConverter"),
    FACTORGROUP("FactorGroup"),
    FASTZERO("Fast Zero"),
    FIXEDAMORTIZINGBOND("Fixed Amortizing Bond"),
    FIXEDINCOMEFORWARD("Fixed Income Forward"),
    FIXEDRATEBOND("Fixed Rate Bond"),
    FLOATINGAMORTIZINGBOND("Floating Amortizing Bond"),
    FLOATINGRATENOTE("Floating Rate Note"),
    FOREIGNEXCHANGE("Foreign Exchange"),
    FOREXFUTURE("Forex Future"),
    HISTORICALRATES("Historical Rates"),
    INDEXCURVE("Index Curve"),
    MARKETINDEX("Market Index"),
    MATRIXPARAMETERCURVE("Matrix Parameter Curve"),
    NOTIONALINDEX("Notional Index"),
    PAYMENTPROCEDURE("Payment Procedure"),
    PORTFOLIO("Portfolio"),
    POSITION("Position"),
    SCENSET("ScenSet"),
    SCENARIOSET("Scenario Set"),
    SPOTCOMMODITY("Spot Commodity"),
    STRUCTUREDCURVEINDEX("Structured Curve Index"),
    TEMPLATE("Template"),
    ZERO("Zero"),
    ZEROCOUPONBOND("Zero Coupon Bond"),
    ZEROCURVE("Zero Curve");

    String descricao;

    private TipoObjetoRisco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
