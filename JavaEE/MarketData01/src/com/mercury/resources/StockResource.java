package com.mercury.resources;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mercury.beans.StockInfo;
import com.mercury.beans.Stock;
import com.mercury.finance.YahooFinance;

@Path("/finance")
public class StockResource {
	private StockInfo stockInfo;
	public StockResource() {
		if (stockInfo==null) {
			stockInfo = new StockInfo();
			stockInfo.setStocks(new ArrayList<Stock>());
			String[] sids = {"C", "BAC", "GS", "GOOG", "EDU", "DRYS", "FB"};
			for (String sid:sids) {
				stockInfo.addStock(new Stock(sid));
			}
		}
	}
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StockInfo execute() {
		YahooFinance.marketData(stockInfo.getStocks());
		return stockInfo;
	}
}
