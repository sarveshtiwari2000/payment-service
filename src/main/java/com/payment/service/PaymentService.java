package com.payment.service;

import com.payment.service.PaymentPlan;
import com.payment.model.Request;
import com.payment.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

	public List<Response> processPayment(final Request request) throws Exception {
		final List<PaymentPlan> paymentPerMonthList = processPaymentList(request);
		return generateResponseList(paymentPerMonthList);
	}

	private List<PaymentPlan> processPaymentList(final Request request) {

		final List<PaymentPlan> paymentPerMonthList = new ArrayList<>();
		paymentPerMonthList.add(firstMonth(request));
		paymentPerMonthList.addAll(remainingMonths(request, paymentPerMonthList.get(0)));
		return paymentPerMonthList;
	}

	private List<PaymentPlan> remainingMonths(final Request request, PaymentPlan previousPaymentPerMonth) {

		final List<PaymentPlan> paymentPerMonthList = new ArrayList<>();

		for (int counter = 1; counter < request.getDuration(); counter++) {
			previousPaymentPerMonth = new PaymentPlan(request, previousPaymentPerMonth, counter);
			paymentPerMonthList.add(previousPaymentPerMonth);
		}

		return paymentPerMonthList;
	}

	private PaymentPlan firstMonth(final Request request) {
		return new PaymentPlan(request);
	}

	private List<Response> generateResponseList(final List<PaymentPlan> paymentPerMonthList) {

		final List<Response> responseList = new ArrayList<>();

		for (final PaymentPlan paymentPerMonth : paymentPerMonthList) {
			final Response response = new Response(paymentPerMonth);
			responseList.add(response);
		}

		return responseList;
	}
}
