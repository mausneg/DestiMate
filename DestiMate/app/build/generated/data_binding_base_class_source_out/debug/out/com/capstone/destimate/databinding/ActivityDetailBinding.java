// Generated by view binder compiler. Do not edit!
package com.capstone.destimate.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.capstone.destimate.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btDetailMap;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final Guideline guideline9;

  @NonNull
  public final ImageView iconItemAddress2;

  @NonNull
  public final ImageView iconItemRating2;

  @NonNull
  public final ImageView imgDetailPhoto;

  @NonNull
  public final RatingBar ratingBar2;

  @NonNull
  public final RecyclerView rvDetailSerupa;

  @NonNull
  public final TextView tvDetailAlamat;

  @NonNull
  public final TextView tvDetailBerikanRating;

  @NonNull
  public final TextView tvDetailBudget;

  @NonNull
  public final TextView tvDetailBudgetIndicator;

  @NonNull
  public final TextView tvDetailCategory;

  @NonNull
  public final TextView tvDetailDescription;

  @NonNull
  public final TextView tvDetailDestinasiSerupa;

  @NonNull
  public final TextView tvDetailName;

  @NonNull
  public final TextView tvDetailRated;

  @NonNull
  public final TextView tvDetailRating;

  private ActivityDetailBinding(@NonNull ConstraintLayout rootView, @NonNull Button btDetailMap,
      @NonNull CardView cardView, @NonNull Guideline guideline9,
      @NonNull ImageView iconItemAddress2, @NonNull ImageView iconItemRating2,
      @NonNull ImageView imgDetailPhoto, @NonNull RatingBar ratingBar2,
      @NonNull RecyclerView rvDetailSerupa, @NonNull TextView tvDetailAlamat,
      @NonNull TextView tvDetailBerikanRating, @NonNull TextView tvDetailBudget,
      @NonNull TextView tvDetailBudgetIndicator, @NonNull TextView tvDetailCategory,
      @NonNull TextView tvDetailDescription, @NonNull TextView tvDetailDestinasiSerupa,
      @NonNull TextView tvDetailName, @NonNull TextView tvDetailRated,
      @NonNull TextView tvDetailRating) {
    this.rootView = rootView;
    this.btDetailMap = btDetailMap;
    this.cardView = cardView;
    this.guideline9 = guideline9;
    this.iconItemAddress2 = iconItemAddress2;
    this.iconItemRating2 = iconItemRating2;
    this.imgDetailPhoto = imgDetailPhoto;
    this.ratingBar2 = ratingBar2;
    this.rvDetailSerupa = rvDetailSerupa;
    this.tvDetailAlamat = tvDetailAlamat;
    this.tvDetailBerikanRating = tvDetailBerikanRating;
    this.tvDetailBudget = tvDetailBudget;
    this.tvDetailBudgetIndicator = tvDetailBudgetIndicator;
    this.tvDetailCategory = tvDetailCategory;
    this.tvDetailDescription = tvDetailDescription;
    this.tvDetailDestinasiSerupa = tvDetailDestinasiSerupa;
    this.tvDetailName = tvDetailName;
    this.tvDetailRated = tvDetailRated;
    this.tvDetailRating = tvDetailRating;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_detail_map;
      Button btDetailMap = ViewBindings.findChildViewById(rootView, id);
      if (btDetailMap == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.guideline9;
      Guideline guideline9 = ViewBindings.findChildViewById(rootView, id);
      if (guideline9 == null) {
        break missingId;
      }

      id = R.id.icon_item_address2;
      ImageView iconItemAddress2 = ViewBindings.findChildViewById(rootView, id);
      if (iconItemAddress2 == null) {
        break missingId;
      }

      id = R.id.icon_item_rating2;
      ImageView iconItemRating2 = ViewBindings.findChildViewById(rootView, id);
      if (iconItemRating2 == null) {
        break missingId;
      }

      id = R.id.img_detail_photo;
      ImageView imgDetailPhoto = ViewBindings.findChildViewById(rootView, id);
      if (imgDetailPhoto == null) {
        break missingId;
      }

      id = R.id.ratingBar2;
      RatingBar ratingBar2 = ViewBindings.findChildViewById(rootView, id);
      if (ratingBar2 == null) {
        break missingId;
      }

      id = R.id.rv_detail_serupa;
      RecyclerView rvDetailSerupa = ViewBindings.findChildViewById(rootView, id);
      if (rvDetailSerupa == null) {
        break missingId;
      }

      id = R.id.tv_detail_alamat;
      TextView tvDetailAlamat = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailAlamat == null) {
        break missingId;
      }

      id = R.id.tv_detail_berikan_rating;
      TextView tvDetailBerikanRating = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailBerikanRating == null) {
        break missingId;
      }

      id = R.id.tv_detail_budget;
      TextView tvDetailBudget = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailBudget == null) {
        break missingId;
      }

      id = R.id.tv_detail_budget_indicator;
      TextView tvDetailBudgetIndicator = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailBudgetIndicator == null) {
        break missingId;
      }

      id = R.id.tv_detail_category;
      TextView tvDetailCategory = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailCategory == null) {
        break missingId;
      }

      id = R.id.tv_detail_description;
      TextView tvDetailDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailDescription == null) {
        break missingId;
      }

      id = R.id.tv_detail_destinasi_serupa;
      TextView tvDetailDestinasiSerupa = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailDestinasiSerupa == null) {
        break missingId;
      }

      id = R.id.tv_detail_name;
      TextView tvDetailName = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailName == null) {
        break missingId;
      }

      id = R.id.tv_detail_rated;
      TextView tvDetailRated = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailRated == null) {
        break missingId;
      }

      id = R.id.tv_detail_rating;
      TextView tvDetailRating = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailRating == null) {
        break missingId;
      }

      return new ActivityDetailBinding((ConstraintLayout) rootView, btDetailMap, cardView,
          guideline9, iconItemAddress2, iconItemRating2, imgDetailPhoto, ratingBar2, rvDetailSerupa,
          tvDetailAlamat, tvDetailBerikanRating, tvDetailBudget, tvDetailBudgetIndicator,
          tvDetailCategory, tvDetailDescription, tvDetailDestinasiSerupa, tvDetailName,
          tvDetailRated, tvDetailRating);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
