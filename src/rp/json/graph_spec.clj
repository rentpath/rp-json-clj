(ns rp.json.graph-spec
  (:require [clojure.spec.alpha :as spec]))

(spec/def :json-graph-ref/$type #{"ref"})
(spec/def ::value any?)
(spec/def ::ref (spec/keys :req-un [:json-graph-ref/$type ::value]))
