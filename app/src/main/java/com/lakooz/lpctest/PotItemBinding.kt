package com.lakooz.lpctest

import android.view.View

class PotItemBinding {

    val root: View = null

    fun bind(item: PromotionItem) {
        with(itemView) {
            promotion_item_title.text = item.title
            promotion_item_subtitle.text = textForDiscount(item.discount)
            promotion_item_description.text = item.description
            promotion_item_special_label.visibility = if (item.isSpecial) View.VISIBLE else View.GONE
        }
    }

    private fun textForDiscount(discount: Discount): String {
        return when (discount) {
            is Discount.Percentage -> "discount ${discount.value}%"
            is Discount.Cash -> "discount ${discount.value}$"
            Discount.Free -> "free item"
        }
    }

}
