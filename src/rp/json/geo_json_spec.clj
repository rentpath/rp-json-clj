(ns rp.json.geo-json-spec
  (:require [clojure.spec.alpha :as spec]))

(spec/def ::longitude (spec/and number? #(<= -180 % 180)))
(spec/def ::latitude (spec/and number? #(<= -90 % 90)))
(spec/def :geo-json/coordinates (spec/tuple ::longitude ::latitude))
(spec/def :geo-json-point/coordinates :geo-json/coordinates)
(spec/def :geo-json-multi-point/coordinates (spec/coll-of :geo-json/coordinates :kind vector?))

(defmulti geo-json-geometry-type :type)
(defmethod geo-json-geometry-type "Point" [_]
  (spec/keys :req-un [:geo-json/type :geo-json-point/coordinates]))
(defmethod geo-json-geometry-type "MultiPoint" [_]
  (spec/keys :req-un [:geo-json/type :geo-json-multi-point/coordinates]))
(spec/def :geo-json/geometry (spec/multi-spec geo-json-geometry-type :type))

(spec/def :geo-json-feature/type #{"Feature"})
(spec/def :geo-json/properties map?)
(spec/def :geo-json/feature (spec/keys :req-un [:geo-json-feature/type :geo-json/geometry :geo-json/properties]))

(spec/def :geo-json-feature-collection/type #{"FeatureCollection"})
(spec/def :geo-json/features (spec/coll-of :geo-json/feature :kind vector?))
(spec/def :geo-json/feature-collection (spec/keys :req-un [:geo-json-feature-collection/type :geo-json/features]))
