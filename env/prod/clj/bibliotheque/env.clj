(ns bibliotheque.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[bibliotheque started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[bibliotheque has shut down successfully]=-"))
   :middleware identity})
