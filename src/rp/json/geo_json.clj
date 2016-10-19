(ns rp.json.geo-json)

(defn feature
  [{:keys [longitude latitude properties]}]
  {:type "Feature"
   :geometry {:type "Point"
              :coordinates [longitude latitude]}
   :properties properties})

(defn feature-collection
  [features]
  {:type "FeatureCollection"
   :features features})
