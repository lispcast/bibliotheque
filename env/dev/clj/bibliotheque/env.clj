(ns bibliotheque.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [bibliotheque.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[bibliotheque started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[bibliotheque has shut down successfully]=-"))
   :middleware wrap-dev})
