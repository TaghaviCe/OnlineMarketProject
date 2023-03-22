package com.example.onlinemarketproject.model


import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class productItemX(

    @Json(name = "category")
    val category: String,
    @Json(name="description")
    val description: String,
    @PrimaryKey(autoGenerate = false)
    @Json(name="id")
    val id: Int,
    @Json(name="image")
    val image: String,
    @Json(name="price")
    val price: Double,
    @Json(name= "rating")
    val rating: Rating,
    @Json(name="title")
    val title: String

)
/*
 @Json(name = "attributes")
    val attributes: List<Any>,
    @Json(name = "average_rating")
    val averageRating: String,
    @Json(name = "backordered")
    val backordered: Boolean,
    @Json(name = "backorders")
    val backorders: String,
    @Json(name = "backorders_allowed")
    val backordersAllowed: Boolean,
    @Json(name = "button_text")
    val buttonText: String,
    @Json(name = "catalog_visibility")
    val catalogVisibility: String,
    @Json(name = "categories")
    val categories: List<Category>,
    @Json(name = "cross_sell_ids")
    val crossSellIds: List<Any>,
    @Json(name = "date_created")
    val dateCreated: String,
    @Json(name = "date_created_gmt")
    val dateCreatedGmt: String,
    @Json(name = "date_modified")
    val dateModified: String,
    @Json(name = "date_modified_gmt")
    val dateModifiedGmt: String,
    @Json(name = "date_on_sale_from")
    val dateOnSaleFrom: Any,
    @Json(name = "date_on_sale_from_gmt")
    val dateOnSaleFromGmt: Any,
    @Json(name = "date_on_sale_to")
    val dateOnSaleTo: Any,
    @Json(name = "date_on_sale_to_gmt")
    val dateOnSaleToGmt: Any,
    @Json(name = "default_attributes")
    val defaultAttributes: List<Any>,
    @Json(name = "description")
    val description: String,
    @Json(name = "dimensions")
    val dimensions: Dimensions,
    @Json(name = "download_expiry")
    val downloadExpiry: Int,
    @Json(name = "download_limit")
    val downloadLimit: Int,
    @Json(name = "downloadable")
    val downloadable: Boolean,
    @Json(name = "downloads")
    val downloads: List<Any>,
    @Json(name = "external_url")
    val externalUrl: String,
    @Json(name = "featured")
    val featured: Boolean,
    @Json(name = "grouped_products")
    val groupedProducts: List<Any>,
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<Image>,
    @Json(name = "_links")
    val links: Links,
    @Json(name = "low_stock_amount")
    val lowStockAmount: Any,
    @Json(name = "manage_stock")
    val manageStock: Boolean,
    @Json(name = "menu_order")
    val menuOrder: Int,
    @Json(name = "meta_data")
    val metaData: List<Any>,
    @Json(name = "name")
    val name: String,
    @Json(name = "on_sale")
    val onSale: Boolean,
    @Json(name = "parent_id")
    val parentId: Int,
    @Json(name = "permalink")
    val permalink: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "price_html")
    val priceHtml: String,
    @Json(name = "purchasable")
    val purchasable: Boolean,
    @Json(name = "purchase_note")
    val purchaseNote: String,
    @Json(name = "rating_count")
    val ratingCount: Int,
    @Json(name = "regular_price")
    val regularPrice: String,
    @Json(name = "related_ids")
    val relatedIds: List<Int>,
    @Json(name = "reviews_allowed")
    val reviewsAllowed: Boolean,
    @Json(name = "sale_price")
    val salePrice: String,
    @Json(name = "shipping_class")
    val shippingClass: String,
    @Json(name = "shipping_class_id")
    val shippingClassId: Int,
    @Json(name = "shipping_required")
    val shippingRequired: Boolean,
    @Json(name = "shipping_taxable")
    val shippingTaxable: Boolean,
    @Json(name = "short_description")
    val shortDescription: String,
    @Json(name = "sku")
    val sku: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "sold_individually")
    val soldIndividually: Boolean,
    @Json(name = "status")
    val status: String,
    @Json(name = "stock_quantity")
    val stockQuantity: Any,
    @Json(name = "stock_status")
    val stockStatus: String,
    @Json(name = "tags")
    val tags: List<Tag>,
    @Json(name = "tax_class")
    val taxClass: String,
    @Json(name = "tax_status")
    val taxStatus: String,
    @Json(name = "total_sales")
    val totalSales: Int,
    @Json(name = "type")
    val type: String,
    @Json(name = "upsell_ids")
    val upsellIds: List<Any>,
    @Json(name = "variations")
    val variations: List<Any>,
    @Json(name = "virtual")
    val virtual: Boolean,
    @Json(name = "weight")
    val weight: String
 */