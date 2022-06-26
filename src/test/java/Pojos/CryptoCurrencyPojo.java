package Pojos;

public class CryptoCurrencyPojo {

    private String cryptocurrency;
    private CustomerInfoPojo customer;

    public CryptoCurrencyPojo() {
    }

    public String getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(String cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public CustomerInfoPojo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInfoPojo customer) {
        this.customer = customer;
    }

    public CryptoCurrencyPojo(String cryptocurrency, CustomerInfoPojo customer) {
        this.cryptocurrency = cryptocurrency;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CryptoCurrencyPojo{" +
                "cryptocurrency='" + cryptocurrency + '\'' +
                ", customer=" + customer +
                '}';
    }
}
