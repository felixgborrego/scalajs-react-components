package chandu0101.scalajs.react.components.demo.pages

import chandu0101.scalajs.react.components.demo.pages.components.demo.DemoLeftNav
import chandu0101.scalajs.react.components.demo.pages.util.LeftnavPage
import chandu0101.scalajs.react.components.demo.routes.AppRouter.AppPage._
import japgolly.scalajs.react.{BackendScope, ReactComponentB, ReactElement}

/**
 * Created by chandrasekharkode .
 */
object GoogleMapPage {

  lazy val menus = List(
    DemoLeftNav.Menu(route = googleMapInfo.path.value, text = "Info"),
    DemoLeftNav.Menu(route = mapbasic.path.value, text = "Basic Map"),
    DemoLeftNav.Menu(route = mapmarkers.path.value, text = "Map with Markers"),
    DemoLeftNav.Menu(route = mapmarkersicon.path.value, text = "Custom Marker Icon"),
    DemoLeftNav.Menu(route = mapmarkerinfowindow.path.value, text = "Marker InfoWindow")
  )

  case class State(checked: Boolean)

  class Backend(t: BackendScope[Props, State]) {

  }

  val component = ReactComponentB[Props]("GoogleMapPage")
    .initialState(State(checked = false))
    .backend(new Backend(_))
    .render((P, S, B) => {
    LeftnavPage(menus, P.content)
  })
    .build

  case class Props(content: ReactElement
                    )

  def apply(content: ReactElement) = component(Props(content))
}