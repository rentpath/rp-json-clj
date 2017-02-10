(ns rp.json.graph-spec
  (:require [clojure.spec :as s]))

(s/def :json-graph-ref/$type #{"ref"})
(s/def ::value any?)
(s/def ::ref (s/keys :req-un [:json-graph-ref/$type ::value]))
