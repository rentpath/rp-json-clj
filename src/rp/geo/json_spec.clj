(ns rp.geo.json-spec
  (:require [clojure.spec :as s]))

(s/def ::longitude (s/and number? #(<= -180 % 180)))
(s/def ::latitude (s/and number? #(<= -90 % 90)))
(s/def :geo-json/coordinates (s/tuple ::longitude ::latitude))
(s/def :geo-json-point/coordinates :geo-json/coordinates)
(s/def :geo-json-multi-point/coordinates (s/coll-of :geo-json/coordinates :kind vector?))

(defmulti geo-json-geometry-type :type)
(defmethod geo-json-geometry-type "Point" [_]
  (s/keys :req-un [:geo-json/type :geo-json-point/coordinates]))
(defmethod geo-json-geometry-type "MultiPoint" [_]
  (s/keys :req-un [:geo-json/type :geo-json-multi-point/coordinates]))
(s/def :geo-json/geometry (s/multi-spec geo-json-geometry-type :type))

(s/def :geo-json-feature/type #{"Feature"})
(s/def :geo-json/properties map?)
(s/def :geo-json/feature (s/keys :req-un [:geo-json-feature/type :geo-json/geometry :geo-json/properties]))

(s/def :geo-json-feature-collection/type #{"FeatureCollection"})
(s/def :geo-json/features (s/coll-of :geo-json/feature :kind vector?))
(s/def :geo-json/feature-collection (s/keys :req-un [:geo-json-feature-collection/type :geo-json/features]))
