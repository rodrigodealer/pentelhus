package com.ts.docs.controller

import com.google.inject.Inject
import com.ts.docs.models.{App, JsonRequest, Version}
import com.ts.docs.services.Apps
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.QueryParam


class AppsController @Inject()(implicit apps: Apps) extends Controller with JsonRequest {

  get("/apps") { request: Request =>
    apps.index()
  }

  get("/list") { request: Request =>
    apps.get()
  }
}

case class AppByIdRequest(@QueryParam id: String)

case class SearchRequest(@QueryParam field: String, @QueryParam value: String)

case class ActivationRequest(@QueryParam id: String, @QueryParam version: String)
