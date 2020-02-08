package warikan.domain.model

import scala.math.BigDecimal.RoundingMode

case class Party(partyName: PartyName, members: List[Member]) {

  def addMember(member: Member): Party = {
    val newMembers = members :+ member
    copy(members = newMembers)
  }

  private def calculateSumRate(paymentRate: PaymentRate): SumRate = {
    val values: Seq[Double] = members.map { member =>
      paymentRate.rate(member.paymentType)
    }
    SumRate(values.sum)
  }

  def calculate(amount: BillAmount, paymentRate: PaymentRate) = {
    val sumRate =  calculateSumRate(paymentRate)

    val x = amount.value.dividedBy(sumRate.value)

    members.map { member =>
      val yyyyy = paymentRate.rate(member.paymentType)
      val amount = x * yyyyy
      (member, amount)
    }
  }

}
case class SumRate(value: Double)
