(ns rp.json.geo-json
  (:require [rp.util.string :as util-string]))

(defn geo-json-feature
  [{:keys [longitude latitude properties]}]
  {:type "Feature"
   :geometry {:type "Point"
              :coordinates [(util-string/parse-double longitude)
                            (util-string/parse-double latitude)]}
   :properties properties})

(defn geo-json-feature-collection
  [features]
  {:type "FeatureCollection"
   :features features})
