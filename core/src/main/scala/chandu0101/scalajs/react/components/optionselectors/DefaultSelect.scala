package chandu0101.scalajs.react.components.optionselectors


import chandu0101.scalajs.react.components.all._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js



/**
 * Created by chandrasekharkode .
 */
object DefaultSelect {

  class Backend(t: BackendScope[Props, _]) {

    def onChange(e:ReactEventI) =  t.props.onChange(e.target.value)
  }

  val component = ReactComponentB[Props]("DefaultSelect")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    val reactselect: String = "reactselect"
    div(cls := reactselect)(
       label( htmlFor := reactselect)(strong(P.label)),
       select( paddingLeft := "5px", id := reactselect , value := P.value , onChange ==> B.onChange)(
         P.options.map(item => option( item))
       )
      )
    })
    .build

  case class Props(label : String,options : List[String] , value : String , onChange : StringUnit)

  def apply(ref: js.UndefOr[String] = "", key: js.Any = {},label : String,options : List[String] , value : String , onChange : StringUnit) = component.set(key, ref)(Props(label,options,value,onChange))
}
