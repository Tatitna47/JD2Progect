package ru.mail.kovgantatyana.repository.model;

import ru.mail.kovgantatyana.repository.model.ItemStatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table
public class Item implements Serializable {
    private static final long serialVersionUID = 2786673804380266137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;
    @Column
    private int inventoryNumber;
    @Column
    private String itemName;
    @Column
    private String description;
    @Column
    private float price;
    @Column
    private ItemStatusEnum itemStatusEnum;

    public ItemStatusEnum getItemStatusEnum() {
        return itemStatusEnum;
    }

    public void setItemStatusEnum(ItemStatusEnum itemStatusEnum) {
        this.itemStatusEnum = itemStatusEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(int inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "ITEM itemName " + itemName + ", description " + description + ", price " + price;
    }
}
