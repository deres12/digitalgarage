package it.digitalgarage.marketplace.offertaasta.be.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import it.digitalgarage.marketplace.offertaasta.be.model.exception.AddBidNotValidException;
import it.digitalgarage.marketplace.offertaasta.be.model.exception.AuctionRangeDateNotValidException;
import it.digitalgarage.marketplace.offertaasta.be.model.princingstrategy.PRICING;
import it.digitalgarage.marketplace.offertaasta.be.model.state.STATE;


@Table
@Entity
public class Auction extends AEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUCTION_ID_SEQ") 
	@SequenceGenerator(name="AUCTION_ID_SEQ", sequenceName="AUCTION_ID_SEQ", allocationSize = 1)
	private Long oid;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne
	private Supplier supplier;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Product product;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startAuction;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endAuction;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastBidDate;
	
	@OneToMany(mappedBy="auction",cascade=CascadeType.ALL)
	private List<Bid> bids = new ArrayList<Bid>();
	
	@Version
	private long version;
	
	@Enumerated(EnumType.STRING)
	private PRICING pricing;
	
	private boolean suspend;
	
	public Auction() {
		this.suspend = false;
		this.pricing = PRICING.UPWARDS;
	}
	
	public Auction(Long oid) {
		this.oid = oid;
	}
	
	public Auction(String title,String description,Supplier supplier,Product product,Date startAuction,Date endAuction,PRICING pricing,boolean suspend) {
		this.title = title;
		this.description = description;
		this.supplier = supplier;
		this.product = product;
		this.startAuction = startAuction;
		this.endAuction = endAuction;
		this.pricing = pricing;
		this.suspend  = suspend;
	}
	
	
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public List<Bid> getBids() {
		return Collections.unmodifiableList(this.bids);
	}
	

	
	public Date getStartAuction() {
		return startAuction;
	}
	

	
	public Date getEndAuction() {
		return endAuction;
	}
	
	public Date getLastBidDate() {
		return lastBidDate;
	}
	
	
	public void setRangeAuction(Date startDate,Date endDate) {
		if(startDate!=null && endDate!=null && startDate.getTime() < endDate.getTime() &&  startDate.getTime() > System.currentTimeMillis() && endDate.getTime() > System.currentTimeMillis()){
			this.startAuction = startDate;
			this.endAuction = endDate;
		}else{
			throw new AuctionRangeDateNotValidException("start date and end date must be future");
		}
	}
	
	
//	public void setEndAuction(Date endAuction) {
//		this.endAuction = endAuction;
//	}
//	
//	public void setStartAuction(Date startAuction) {
//		this.startAuction = startAuction;
//	}
//	public void setBids(List<Bid> bids) {
//		this.bids = bids;
// }

	@Override
	public String toString() {
		return "Auction [getOid()=" + getOid() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getSupplier()=" + getSupplier() +", getProduct() =" + getProduct() + super.toString() + "]";
	}

	
	
	public void addBid(Bid bid) throws AddBidNotValidException{
		if(getSTATE().canAddBid()){
			if(getPricing().canAdd(getBids(), bid)){
				bid.setAuction(this);
				this.bids.add(bid);
				this.lastBidDate = bid.getTime();
			}else{
				throw new AddBidNotValidException("Bad Price is not valid");
			}
		}else{
			throw new AddBidNotValidException("Bad State is not valid");
		}
	}
	
	@Transient         
	public Bid getCurrentWinning(){
		return getPricing().currentBid(getBids());
	}
	
	@Transient
	public STATE getSTATE(){
		return STATE.eval(this);
	}
	
	public long getVersion() {
		return version;
	}
	
	public void setVersion(long version) {
		this.version = version;
	}

	public boolean isSuspend() {
		return suspend;
	}
	
	
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	
	
	public PRICING getPricing() {
		return pricing;
	}
	
	

}
