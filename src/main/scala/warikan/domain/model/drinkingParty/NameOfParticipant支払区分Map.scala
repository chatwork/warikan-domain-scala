package warikan.domain.model.drinkingParty

import warikan.domain.model.money.Money
import warikan.domain.model.支払区分.支払区分

class NameOfParticipant支払区分Map(value: Map[NameOfParticipant, 支払区分]) {
  def sumMoney(): Money = ???

  def map[A](function: (NameOfParticipant, 支払区分) => A): Seq[A] = ???

}
