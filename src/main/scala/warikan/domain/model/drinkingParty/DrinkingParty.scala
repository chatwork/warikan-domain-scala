package warikan.domain.model.drinkingParty

import java.time.LocalDate

import warikan.domain.model.money.Money
import warikan.domain.model.支払区分.支払区分

/**
  * 飲み会
  */
class DrinkingParty(name: DrinkingPartyName,
                    date: LocalDate,
                    nameOfParticipant支払区分Map: NameOfParticipant支払区分Map,
                    _支払区分PercentageMap: 支払区分PercentageMap) {

  def addParticipant(nameOfParticipant: NameOfParticipant, _支払区分: 支払区分): DrinkingParty = ???

  def removeParticipant: DrinkingParty = ???

  def set支払区分PercentageMap(map: 支払区分PercentageMap): DrinkingParty = ???

  def sumParticipant: SumParticipant = ???

  private def 整数値出して(支払合計金額: Money): Money = ???

  def warikan(_請求金額: 請求金額): (差額, Map[NameOfParticipant, Money]) = {
    val averagePrice = _請求金額 / sumParticipant.value
    val result = nameOfParticipant支払区分Map.map { (nameOfParticipant, _支払区分) =>
      nameOfParticipant -> averagePrice * _支払区分PercentageMap.get(_支払区分).value
    }
    val 支払合計金額 = nameOfParticipant支払区分Map.sumMoney()
    val _差額 = _請求金額 - 整数値出して(支払合計金額)
    new 差額(_差額) -> result.toMap
  }
}
